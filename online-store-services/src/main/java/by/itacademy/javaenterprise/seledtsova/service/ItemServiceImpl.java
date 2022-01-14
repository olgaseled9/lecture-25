package by.itacademy.javaenterprise.seledtsova.service;

import by.itacademy.javaenterprise.seledtsova.convectors.ItemServiceConverter;
import by.itacademy.javaenterprise.seledtsova.dao.ItemDao;
import by.itacademy.javaenterprise.seledtsova.dto.ItemDTO;
import by.itacademy.javaenterprise.seledtsova.entity.Item;
import by.itacademy.javaenterprise.seledtsova.exception.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    @Autowired
    private final ItemDao itemDao;
    @Autowired
    private final ItemServiceConverter converter;

    @Override
    @Transactional
    public List<ItemDTO> getItems() {
        List<Item> items = itemDao.findAll();
        List<ItemDTO> itemDTOS = new ArrayList<>();
        for (Item item : items) {
            itemDTOS.add(converter.convertItemToDTO(item));
        }
        return itemDTOS;
    }

    @Override
    @Transactional
    public void addItem(ItemDTO itemDTO) {
        itemDao.saveItem(converter.convertDTOtoItem(itemDTO));
    }

    @Override
    @Transactional
    public ItemDTO findItemById(Long id) {
        Item item = itemDao.findItemById(id);
        if (Objects.nonNull(item)) {
            return converter.convertItemToDTO(item);
        } else {
            throw new ServiceException(String.format("Item is not found with id=", id));
        }
    }
}

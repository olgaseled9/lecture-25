package by.itacademy.javaenterprise.seledtsova.controllers;

import by.itacademy.javaenterprise.seledtsova.dto.ItemDTO;
import by.itacademy.javaenterprise.seledtsova.service.ItemService;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ItemController {

    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public String getAll(Model model) {
        List<ItemDTO> items = itemService.getItems();
        model.addAttribute("items", items);
        return "items";
    }

    @GetMapping("/add-item")
    public String addItemPage(ItemDTO itemDTO, Model model) {
        return "add_item";
    }

    @PostMapping("/add-item")
    public String addNewItem(ItemDTO itemDTO, BindingResult bindingResult, @RequestParam(value = "avatar", required = false) MultipartFile multipartFile) {
        if (!bindingResult.hasErrors()) {
            itemService.addItem(itemDTO);
            try {
                if (multipartFile != null && !multipartFile.isEmpty()) {
                    validateImage(multipartFile);
                    saveImage(itemDTO.getName() + ".jpg", multipartFile);
                    logger.info("Image add successfully");
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.error("Image did not add");
            }
            logger.info("New item add successfully");
            return "redirect:/items";
        } else {
            logger.error("Item not added");
            return "items";
        }
    }

    private void validateImage(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.getContentType().equals("image/jpeg")) {
            throw new IOException("Only JSP image are accepted!");
        }
    }

    private void saveImage(String filename, MultipartFile multipartFile) throws IOException {
        File file = new File("C:\\Users\\kan38\\IdeaProjects\\lecture-25\\online-store-web\\src\\main\\resources" + filename);
        FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
        logger.info(file.getAbsolutePath());
    }
}

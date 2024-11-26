package com.school.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.school.constants.ContentCategory;
import com.school.model.Content;

@Controller
@RequestMapping("/library")
public class LibraryController {
    // Temporary for now, will add actual database later
    private static final ArrayList<Content> contents = new ArrayList<>();

    public LibraryController() {
        // Add dummy content data
        for (int i = 0; i < 5; i++) {
            final Content content = new Content();

            content.setId(String.valueOf(i + 1));
            content.setTitle("Introduction to " + (i % 2 == 0 ? "Java" : "Python"));
            content.setAuthor("Fadhil Raihan Gunawan");
            content.setCategory(ContentCategory.PROGRAMMING);
            content.setUploadedDate(new Date());
            contents.add(content);
        }
    }

    @GetMapping
    public String getIndex() {
        return "library/index";
    }

    @GetMapping("/contents")
    public ModelAndView getContents(@RequestParam(defaultValue = "") String searchQuery,
            @RequestParam(defaultValue = "1") Integer page) {
        // Ensure page does not go out of bounds
        page = Math.max(page, 1);
        searchQuery = searchQuery.trim();

        final ModelAndView model = new ModelAndView("library/contents");

        int contentsPerPage = 20;

        model.addObject("searchQuery", searchQuery);
        model.addObject("page", page);

        // Filter contents based on search query
        if (!searchQuery.isEmpty()) {
            final ArrayList<Content> filteredContents = new ArrayList<>();

            for (Content content : contents) {
                if (content.getTitle().toLowerCase().contains(searchQuery.toLowerCase())
                        || content.getAuthor().toLowerCase().contains(searchQuery.toLowerCase())
                        || content.getCategory().name().toLowerCase().contains(searchQuery.toLowerCase())) {
                    filteredContents.add(content);
                }

                if (filteredContents.size() == contentsPerPage) {
                    break;
                }
            }

            model.addObject("items", filteredContents);
        } else {
            model.addObject("items",
                    contents.subList((page - 1) * contentsPerPage, Math.min(page * contentsPerPage, contents.size())));
        }

        return model;
    }

    @GetMapping("/upload")
    public String getUploadForm() {
        return "library/upload";
    }

    @SuppressWarnings("null")
    @PostMapping(value = "/upload", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postUploadContent(@RequestBody MultiValueMap<String, String> formData) {
        if (!formData.containsKey("link") || formData.getFirst("link").isEmpty()) {
            return "redirect:/library/upload";
        }

        if (!formData.containsKey("category") || formData.getFirst("category").isEmpty()) {
            return "redirect:/library/upload";
        }

        // TODO: request YouTube for video information. For now, use dummy data
        final Content content = new Content();

        content.setId(String.valueOf(contents.size() + 1));
        content.setTitle("Dummy title " + (contents.size() + 1));
        content.setAuthor("Dummy author " + (contents.size() + 1));
        content.setCategory(ContentCategory.from(formData.getFirst("category")));
        content.setUploadedDate(new Date());

        contents.add(content);

        return "redirect:/library/contents";
    }
}
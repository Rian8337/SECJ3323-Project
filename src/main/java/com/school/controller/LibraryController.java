package com.school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.school.constants.ContentCategory;
import com.school.entity.User;
import com.school.service.ContentService;

@Controller
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private ContentService contentService;

    @GetMapping
    public String getIndex() {
        return "library/index.html";
    }

    @GetMapping("/contents")
    public String getContents(@RequestParam(defaultValue = "") String searchQuery,
            @RequestParam(defaultValue = "1") Integer page, Model model) {
        // Ensure page does not go out of bounds
        page = Math.max(page, 1);
        searchQuery = searchQuery.trim();

        final int contentsPerPage = 20;
        final var contents = contentService.searchContents(searchQuery, page, contentsPerPage);

        model.addAttribute("items", contents);
        model.addAttribute("searchQuery", searchQuery);
        model.addAttribute("page", page);

        return "library/contents.html";
    }

    @GetMapping("/upload")
    public String getUploadForm(final Model model) {
        if (!model.containsAttribute("toastMessage")) {
            model.addAttribute("toastMessage", "");
        }

        model.addAttribute("link", "");
        model.addAttribute("selectedCategory", "");
        model.addAttribute("categories", ContentCategory.values());

        return "library/upload.html";
    }

    @PostMapping(value = "/upload", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String postUploadContent(final Model model, @RequestBody MultiValueMap<String, String> formData,
            RedirectAttributes redirectAttributes) {
        final var link = formData.getFirst("link");
        final var categoryStr = formData.getFirst("category");

        if (link == null || link.isEmpty()) {
            redirectAttributes.addFlashAttribute("toastMessage", "Please provide a valid YouTube video link.");
            return "redirect:/library/upload";
        }

        // Ensure the link is a valid YouTube link
        String videoId = null;

        if (link.contains("youtube.com/watch?v=")) {
            videoId = link.split("v=")[1];
        } else if (link.contains("youtu.be/")) {
            videoId = link.split("be/")[1];
        }

        if (videoId == null) {
            redirectAttributes.addFlashAttribute("toastMessage", "Please provide a valid YouTube video link.");
            return "redirect:/library/upload";
        }

        if (categoryStr == null || categoryStr.isEmpty()) {
            redirectAttributes.addFlashAttribute("toastMessage", "Please provide a valid category.");
            return "redirect:/library/upload";
        }

        // TODO: replace with actual user
        final var user = new User();
        final var category = ContentCategory.from(categoryStr);

        user.setId(1);
        user.setName("Hey haha XD");

        try {
            final var content = contentService.uploadContent(user, videoId, category);

            if (content == null) {
                redirectAttributes.addFlashAttribute("toastMessage", "Content not found.");
                return "redirect:/library/upload";
            }

            model.addAttribute("content", content);

            return "library/uploadSuccess.html";
        } catch (Exception e) {
            model.addAttribute("toastMessage", "An error occurred while uploading the content.");
            return "redirect:/library/upload";
        }
    }

    @GetMapping("/viewContent")
    public String getViewContent(final Model model, @RequestParam Long id) {
        if (id == null) {
            return "redirect:/library/contents";
        }

        final var content = contentService.getContentById(id);

        if (content == null) {
            return "redirect:/library/contents";
        }

        model.addAttribute("content", content);

        return "library/viewContent.html";
    }
}

package com.skovpenma.projectmanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/projects")
    public String viewProjectsPage() {
        return "projects";
    }

    @GetMapping("/create-project")
    public String createProjectPage() {
        return "createProject";
    }

    @GetMapping("/tasks")
    public String viewTasksPage() {
        return "tasks";
    }

    @GetMapping("/users")
    public String viewUsersPage() {
        return "users";
    }
}

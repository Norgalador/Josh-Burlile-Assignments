package com.codingdojo.projectmanager.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.UserService;




@Controller
public class ProjectController {

	  @Autowired
	  private UserService userService;
	  @Autowired
	  private ProjectService projectService;
	  
	
	//***** Book Routes ******
	 
	// Dashboard route
	// Check if user is in session for all get routes
	 @GetMapping("/dashboard")
	 public String dashboard(HttpSession session, Model projectModel) {
		 
		 //	Check if user is in session
		 if(session.getAttribute("loggedInUser")!=null) {
			 User user=(User)session.getAttribute("loggedInUser");
//			 User userLoggedIn=userService.findById(user.getId());
			 projectModel.addAttribute("loggedInUser", userService.findById(user.getId()));
			 projectModel.addAttribute("unassignedProjects", projectService.getUnassignedUsers(userService.findById(user.getId())));
			 projectModel.addAttribute("assignedProjects", projectService.getAssignedUsers(userService.findById(user.getId())));
			 return "dashboard.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
	 }

	 	
	 
//		New Project
	 	@GetMapping("/newProject")
	 	public String newProject(HttpSession session, 
	 			@ModelAttribute("newProject") Project project) {
	 		// Check if user is in session
			 if(session.getAttribute("loggedInUser")!=null) {
				return "newProject.jsp";
			 }
			 else {
				 return "redirect:/";
			 }
	 	}
	 	
//		Create Project
	 	@PostMapping("/createProject")
	 	public String createProject(@Valid @ModelAttribute("newProject") Project project,
	 			BindingResult result) {
	 		if(result.hasErrors()) {
	 			return "newProject.jsp";
	 		}
	 		else {
	 			projectService.createProject(project);
	 			return "redirect:/dashboard";
	 		}
	 	}
	 	
	 	
//		Get one Project details - allow edit/delete
	 	@GetMapping("/projectDetails/{id}")
	 	public String projectDetails(@PathVariable Long id,
	 			Model projectModel,
	 			HttpSession session) {
	 		// Check if user is in session
			 if(session.getAttribute("loggedInUser")!=null) {
				 Project myProject=projectService.getOneProject(id);
				 projectModel.addAttribute("project", myProject);
				 return "showProject.jsp";
			 }
			 else {
				 return "redirect:/";
			 }
	 	}
	 
	 	
//		Delete Project
	 	@DeleteMapping("/deleteProject/{id}")
	 	public String deleteProject(@PathVariable Long id,
	 			HttpSession session) {
	 		// Check if user is in session
			 if(session.getAttribute("loggedInUser")!=null) {
				projectService.deleteProject(id);
				return "redirect:/dashboard";
			 }
			 else {
				 return "redirect:/";
			 }
	 	}
	 	
//		Edit Project
	 	@GetMapping("/editProject/{id}")
	 	public String editProject(HttpSession session,
	 			@PathVariable Long id, 
	 			Model projectModel) {
	 		// Check if user is in session
		 if(session.getAttribute("loggedInUser")!=null) {
			projectModel.addAttribute("updateProject", projectService.getOneProject(id));
			return "editProject.jsp";
		 }
		 else {
			 return "redirect:/";
		 }
 	}
			
//		Update Project
	 	@PutMapping("/updateProject/{id}")
	 	public String updateProject(@Valid @ModelAttribute("updateProject") Project editedProject,
	 			BindingResult result) {
	 		// Check if user is in session
	 		if(result.hasErrors()) {
	 			return "editProject.jsp";
			 }
			 else {
				 projectService.updateProject(editedProject);
				 return "redirect:/dashboard";
			 }
	 	}
	 	
//		Join Project team
	 	@GetMapping("/joinProject/{id}")
	 	public String joinTeam(@PathVariable Long id, HttpSession session) {
	 		Project project=projectService.getOneProject(id);
	 		User user=(User)session.getAttribute("loggedInUser");
	 		User UserWhoIsJoining=userService.findById(user.getId());
	 		userService.joinTeam(project, UserWhoIsJoining);
	 		return "redirect:/dashboard";
	 	}
	 	
//		Leave Project team
	 	@GetMapping("/leaveProject/{id}")
	 	public String leaveTeam(@PathVariable Long id, HttpSession session) {
	 		Project project=projectService.getOneProject(id);
	 		User user=(User)session.getAttribute("loggedInUser");
	 		User UserWhoIsLeaving=userService.findById(user.getId());
	 		userService.leaveTeam(project, UserWhoIsLeaving);
	 		return "redirect:/dashboard";
	 	}
	 
}
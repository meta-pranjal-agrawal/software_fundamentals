package com.example.demo.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Employee;
import com.example.demo.model.Image;
import com.example.demo.model.Login;
import com.example.demo.model.Pass;
import com.example.demo.model.Vehicle;
import com.example.demo.service.ServiceImplementation;

@Controller
public class HomeController {

	private static String UPLOADED_FOLDER = "C:\\Users\\Pranjal\\Documents\\workspace-spring-tool-suite-4-4.5.1.RELEASE\\EADSession9\\src\\main\\resources\\static\\images";
	@Autowired
	private ServiceImplementation service;

	@GetMapping({ "/", "/login" })
	public String login(Model model) {

		model.addAttribute("login", new Login());
		return "login";
	}

	@PostMapping("/login")
	public String onLogin(@Validated @ModelAttribute("login") Login login, BindingResult bindingResult,
			HttpSession session, Model model) {

		if (bindingResult.hasErrors()) {
			model.addAttribute("msg", "Login Unsuccessful");
			return "login";
		} else {
			try {
				if (service.validateUser(login)) {

					session.setAttribute("employee", login);

					if (service.checkImageExists(session) == null) {

						session.setAttribute("name", "snap.PNG");
					} else {

						String name = service.checkImageExists(session);
						session.setAttribute("name", name);
					}

					return "redirect:/home";
				} else {
					model.addAttribute("msg", "Login Unsuccessful");
					return "login";
				}
			} catch (Exception e) {

				e.printStackTrace();

				model.addAttribute("msg", "Login Unsuccessful");
				return "login";
			}
		}
	}

	@GetMapping("/home")
	public String home(Login login, Model model, HttpSession session, HttpServletResponse response)
			throws SQLException {

		if (isSessionValid(session, response)) {
			login = (Login) session.getAttribute("employee");
			HashMap<Employee, Vehicle> list = service.showDetails(login);
			for (Employee iterator : list.keySet()) {
				model.addAttribute("employee", iterator);
				model.addAttribute("vehicle", list.get(iterator));
			}
			return "home";
		} else {
			return "redirect:/login";
		}
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("employee", new Employee());
		return "register";
	}

	@PostMapping("/register")
	public String onRegister(@Validated @ModelAttribute("employee") Employee employee, BindingResult bindingResult,
			HttpSession session) {
		try {
			if (bindingResult.hasErrors()) {

				return "register";
			} else {
				if (service.checkUserExists(employee)) {

					service.addUserDetails(employee);
					session.setAttribute("employeeDetails", employee);
					return "redirect:/vehicleRegistration";
				} else {
					return "redirect:/login";
				}
			}
		} catch (Exception e) {
			System.out.println("Invalid Credentials");
			return "redirect:/login";
		}
	}

	@GetMapping("/vehicleRegistration")
	public String VehicleRegistration(Model model, HttpSession session, HttpServletResponse response) {

		model.addAttribute("vehicleRegistration", new Vehicle());
		return "vehicleRegistration";

	}

	@PostMapping("/vehicleRegistration")
	public String onVehicleRegister(@Validated @ModelAttribute("vehicleRegistration") Vehicle vehicle,
			BindingResult bindingResult, Employee employee, HttpSession session, Model model) throws SQLException {
		if (bindingResult.hasErrors()) 
		{
			return "vehicleRegistration";
		} 
		else 
			{
				List<Integer> listOfPrices = service.addVehicleDetails(vehicle, employee, session);
				model.addAttribute("list", listOfPrices);
				model.addAttribute("pass", new Pass());
				return "passDetails";
			}

	}

	@PostMapping("/passDetails")
	public String onGetPass(@Validated @ModelAttribute("pass") Pass pass, BindingResult bindingResult,
			HttpSession session) throws SQLException {
		service.getPass(pass, session);
		return "showPass";
	}

	@GetMapping("/friends")
	public String friends(HttpSession session, Model model, HttpServletResponse response) throws SQLException {

		if (isSessionValid(session, response)) {
			ArrayList<Employee> list = service.showFriends(session);
			model.addAttribute("friendlist", list);
			return "friend";
		}
		return "redirect:/login";
	}

	@GetMapping("/upload")
	public String upload(Model model, HttpSession session, HttpServletResponse response) {
		if (isSessionValid(session, response)) {
			model.addAttribute(new Image());
			return "uploadImage";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping(value = "/upload")
	public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,
			Image image, HttpSession session, Model model) {

		Path path = null;
		if (file.isEmpty()) {

			return "uploadImage";
		}

		try {

			byte[] bytes = file.getBytes();
			image.setImageData(bytes);
			path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			String name = "images" + file.getOriginalFilename();
			service.addImageName(session, name);
			session.setAttribute("name", name);
			return "redirect:/home";

		} catch (IOException e) {
			e.printStackTrace();
			return "uploadImage";

		} catch (SQLException e) {
			e.printStackTrace();
			return "uploadImage";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

	public static boolean isSessionValid(HttpSession session, HttpServletResponse response) {
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		if (session.getAttribute("employee") == null) {
			return false;
		}
		return true;
	}

}

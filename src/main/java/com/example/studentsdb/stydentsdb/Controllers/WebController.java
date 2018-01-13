package com.example.studentsdb.stydentsdb.Controllers;

import com.example.studentsdb.stydentsdb.Model.DTO.GroupsDTO;
import com.example.studentsdb.stydentsdb.Model.DTO.StudentDTO;
import com.example.studentsdb.stydentsdb.Model.Forms.AddGroupForm;
import com.example.studentsdb.stydentsdb.Model.Groups;
import com.example.studentsdb.stydentsdb.Service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;

@Controller
public class WebController {

    @Autowired
    GroupService groupService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test(Model model) {
        model.addAttribute("groups", groupService.getAllGroupsDTO());
        return "index";
    }

    @RequestMapping(value = "/addGroup", method = RequestMethod.GET)
    public String getAddPage(Model model) {
        AddGroupForm form = new AddGroupForm();
        model.addAttribute("addForm", form);
        return "addGroup";
    }

    @RequestMapping(value = "/addGroup", method = RequestMethod.POST)
    public String saveCompany(Model model, @ModelAttribute("addForm") AddGroupForm form) {
        try {
            ArrayList<StudentDTO> list = new ArrayList<>();
            System.out.println(form.getGroup_number() + " " + form.getYear());
            GroupsDTO groupsDTO = new GroupsDTO(Integer.parseInt(form.getGroup_number()),
                                                Integer.parseInt(form.getYear()), list);
            groupService.addGroup(groupsDTO);
            return "redirect:/";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "addGroup";
        }
    }

    @RequestMapping(value = { "/groupProfile" }, method = RequestMethod.GET)
    public String getProfile(Model model, @ModelAttribute("group_number") String number/*, @ModelAttribute("year") String year*/) {
        //try{
            GroupsDTO groupsDTO = groupService.find(Integer.parseInt(number.substring(0,1)),
                                                    Integer.parseInt(number.substring(1)));
            model.addAttribute("group", groupsDTO);
            model.addAttribute("students", groupsDTO.getStudents());
            return "groupPageN";
        //}
        //catch (Exception e){
        //    return "redirect:/";
        //}
    }
}

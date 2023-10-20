package com.example.hibernatecustomermanagement.controller;

import com.example.hibernatecustomermanagement.model.Customer;
import com.example.hibernatecustomermanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customers") //Theo dung qui tac thi duong dan den controller se la ten cua class model + "s"
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public ModelAndView showList(){
        ModelAndView modelAndView = new ModelAndView("/views/customer/list");
        modelAndView.addObject("customers", customerService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showFormCreate(){
        //Tra ve form tao moi
        return new ModelAndView("/views/customer/create");
    }

    @PostMapping("/create")
    public String save(Customer customer){
        //Goi ra ham save de them moi do chua co id trong bang CSDL
        customerService.save(customer);
        //Sau khi an nut Add se quay ve ds
        return ("redirect:/customers");
    }

    @GetMapping("/update/{id}")
    public ModelAndView showFormUpdate(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("/views/customer/update");
        //Tao 1 doi tuong customer duoc tim theo id, do findById thuoc KDL Optional nen phai them .get()
        //de lay duoc cac thong tin cua customer
        Customer customer = customerService.findById(id).get();
        modelAndView.addObject("customerUp", customer);
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, Customer customer){
        //Goi ra ham save de sua thong tin do da co id trong bang CSDL
        customerService.save(customer);
        return ("redirect:/customers");
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        customerService.remove(id);
        return ("redirect:/customers");
    }

    @GetMapping("/view/{id}")
    public String View(@PathVariable Long id, Model model){
        //do findById thuoc KDL Optional nen phai them .get() de lay duoc thong tin customer o view.html
        model.addAttribute("customerView", customerService.findById(id).get());
        return "/views/customer/view";
    }
}

package com.example.springbookstudy.web;

import com.example.springbookstudy.domain.Customer;
import com.example.springbookstudy.service.CustomerService;
import org.apache.coyote.Response;
import org.apache.juli.logging.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    CustomerService customerService;


    @ModelAttribute
    CustomerForm setUpForm() {
        return new CustomerForm();
    }

    @RequestMapping(method = RequestMethod.GET)
    String list(Model model) {
        List<Customer> customers = customerService.findAll();
        model.addAttribute("customers", customers);
        return "customers/list";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    String create(@Validated CustomerForm form, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return list(model);
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customerService.create(customer);
        return "redirect:/customers";
    }

    /*Todo : ReqeustMapping 이해하기, value params에 대해서
        value가 붙으면 URI 에서 매핑시에 해당하는 주소로 매핑을 시킨다.
          params는 그 뒤, ~~~/customers/edit?[params]=(html에서 해당 name의 value 값)
          에 해당하는 값들이 들어가진다. 예시 : ~~~/customers/edit?form=편집
          그 다음 매개변수(Parameter) 위치에 써져있는것들 중 @RequestParam을 적으면
          자바코드 내에서 변수로 사용이 가능해지고 URI 의 쿼리문뒤에 붙게됨.
          예시 : ~~~/customers/edit?form=편집&id=1(customer.id)*/
    @RequestMapping(value = "edit", /*params = "form",*/ method = RequestMethod.GET)
    String editForm(@RequestParam Integer id, CustomerForm form) {
        Customer customer = customerService.findOne(id);
        BeanUtils.copyProperties(customer, form);
        System.out.println("edit Form...");
        return "customers/edit";
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    String edit(@RequestParam Integer id, @Validated CustomerForm form
            , BindingResult result, RedirectAttributes rt) {
        //RedirectAttributes 를 사용하여 1회성으로 리다이렉트시 alert사용을 위한 msg 전송.
        if (result.hasErrors()) {
            System.out.println("edit if문...");
            return editForm(id, form);
        }
        System.out.println("edit...");
        Customer customer = new Customer();
        BeanUtils.copyProperties(form, customer);
        customer.setId(id);
        customerService.update(customer);
        String msg = "성공적으로 변경되었습니다.";
        rt.addFlashAttribute("msg", msg);
        return "redirect:/customers";
    }

    @RequestMapping(value = "edit", params = "goToTop")
    String goToTop(){
        return "redirect:/customers";
    }

    @RequestMapping(value = "delete",method = RequestMethod.POST)
    String delete(@RequestParam Integer id, RedirectAttributes rt){
        System.out.println("[CONTROLLER]delete : id = " + id);
        customerService.delete(id);
        String msg = "성공적으로 삭제되었습니다.";
        rt.addFlashAttribute("msg", msg);
        return "redirect:/customers";
    }
}
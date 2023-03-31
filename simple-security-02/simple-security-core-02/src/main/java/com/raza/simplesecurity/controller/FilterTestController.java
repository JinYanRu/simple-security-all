package com.raza.simplesecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * to do
 *
 * @author Raza
 * @date 2023/3/29
 */
@RestController
public class FilterTestController {
    @GetMapping("filter")
    public void filter(){
        System.out.println("111");
    }
}

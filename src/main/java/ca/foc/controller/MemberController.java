package ca.foc.controller;

import ca.foc.domain.Member;
import ca.foc.domain.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * ******************************************** **
 * MemberController - ca.foc.controller.MemberController
 *
 * @author Christian Garrovillo
 * Information and Communications Technologies
 * Software Development
 * * ********************************************* **
 */
@RestController
@RequestMapping("/members")
public class MemberController {

    public boolean logout() {} //not necessary?


    public List<Product> addProductToFavourites(@PathVariable long id) {
        //dao add, return favourites list
        return null;
    }

    public List<Product> deleteFromFavourtes(@PathVariable long id) {
        return null;
    }

    //how will this work?
    @PutMapping
    public Member editAccount(@RequestBody Member updatedMember) {
        return null;
    }

    @DeleteMapping
    public boolean deleteAccount() {
        return false;
    }

    @PostMapping
    public Member createAccount(@RequestBody Member newMember) {
        return null;
    }


}

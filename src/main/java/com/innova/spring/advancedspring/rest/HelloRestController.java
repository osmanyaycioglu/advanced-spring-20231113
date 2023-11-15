package com.innova.spring.advancedspring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

// @Controller // MVC Model View Controller Pattern
// @ResponseBody
@RestController
@RequestMapping("/hello")
public class HelloRestController {

    // @RequestMapping(method = RequestMethod.GET,path = "/greet1")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/greet1")
    public String gr1() {
        return "Hello world";
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/greet1")
    public String gr2() {
        return "Hello world POST";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    @PutMapping("/greet1")
    public String gr3() {
        return "Hello world PUT";
    }

    @PatchMapping("/greet1")
    public String gr4() {
        return "Hello world PATCH";
    }

    @DeleteMapping("/greet1")
    public String gr5() {
        return "Hello world DELETE";
    }

    // 1.yol
    // /hello/greet2?name=osman
    @GetMapping("/greet2")
    public String gr1(@RequestParam("name") String nameStringParam) {
        return "Hello 2 : " + nameStringParam;
    }

    // /hello/greet3?name=osman&sname=yaycioglu
    @GetMapping("/greet3")
    public String gr2(@RequestParam("name") String nameStringParam,
                      @RequestParam("sname") String surnameStringParam) {
        return "Hello 3 : " + nameStringParam + " " + surnameStringParam;
    }

    // 2.yol
    // /hello/greet4/osman
    @GetMapping("/greet4/{xyz}")
    public String gr4(@PathVariable("xyz") String nameStringParam) {
        return "Hello 4 : " + nameStringParam;
    }

    // /hello/greet5/osman/test/yaycioglu
    @GetMapping("/greet5/{xyz}/test/{abc}")
    public String gr5(@PathVariable("xyz") String nameStringParam,
                      @PathVariable("abc") String surnameStringParam) {
        return "Hello 5 : " + nameStringParam + " " + surnameStringParam;
    }

    // /hello/greet6/osman?abc=yaycioglu
    @GetMapping("/greet6/{xyz}")
    public String gr6(@PathVariable("xyz") String nameStringParam,
                      @RequestParam("abc") String surnameStringParam) {
        return "Hello 6 : " + nameStringParam + " " + surnameStringParam;
    }

    // /hello/greet7/ali;sname=yay;age=53;names=mehmet;names=kemal
    @GetMapping("/greet7/{xyz}")
    public String gr7(@PathVariable("xyz") String nameStringParam,
                      @MatrixVariable("sname") String surnameStringParam,
                      @MatrixVariable("age") Integer integerParam,
                      @MatrixVariable("names") List<String> names) {
        return "Hello 7 : " + nameStringParam + " " + surnameStringParam + " " + integerParam + " : " + names;
    }

    @PostMapping("/greet8")
    @ResponseStatus(HttpStatus.CREATED)
    public String gr8(@RequestBody GreetingsObject greetingsObjectParam) {
        return "" + greetingsObjectParam;
    }

    // Yapmayın
    @PostMapping("/greet9")
    @ResponseStatus(HttpStatus.CREATED)
    public ReponseObject<GreetingsObject> gr9(@RequestBody GreetingsObject greetingsObjectParam) {
        ReponseObject<GreetingsObject> reponseObjectLoc = new ReponseObject<>();
        greetingsObjectParam.setName("processed");
        reponseObjectLoc.setValue(greetingsObjectParam);
        reponseObjectLoc.setErrorOccured(false);
        return reponseObjectLoc;
    }

    @PostMapping("/greet10")
    public GreetingsObject gr10(@RequestBody GreetingsObject greetingsObjectParam) {
        greetingsObjectParam.setName("processed");
        return greetingsObjectParam;
    }

    @PostMapping("/greet11")
    public ResponseEntity<GreetingsObject> gr11(@RequestBody GreetingsObject greetingsObjectParam) {
        greetingsObjectParam.setName("processed");
        return ResponseEntity.status(299)
                             .header("accpeted",
                                     "128937")
                             .body(greetingsObjectParam);
    }

    // yapmayın
    @PostMapping("/greet11/{ops}")
    public ResponseEntity<?> gr2(@PathVariable String ops,
                                 HttpServletRequest requestParam) {
        switch (ops) {
            case "add": {
                Map<String, String[]> parameterMapLoc = requestParam.getParameterMap();
                System.out.println(parameterMapLoc);
                return ResponseEntity.status(200)
                                     .body("eklendi");
            }
            case "delete": {
                Map<String, String[]> parameterMapLoc = requestParam.getParameterMap();
                System.out.println(parameterMapLoc);
                return ResponseEntity.status(200)
                                     .body("deleted");
            }
        }
        return null;
    }

    @PostMapping("/greet12")
    public ResponseEntity<GreetingsObject> gr12(@RequestBody GreetingsObject greetingsObjectParam,
                                                @RequestHeader("X-Forwarded-For") String remoteIp) {
        greetingsObjectParam.setName("processed");
        System.out.println("Ip Addr :" + remoteIp);
        return ResponseEntity.status(299)
                             .header("accpeted",
                                     "128937")
                             .body(greetingsObjectParam);
    }

    @PostMapping("/greet13")
    public String gr13(@RequestParam("name") String nameStringParam,
                       @RequestParam("sname") String surnameStringParam) {
        return "Hello 13 : " + nameStringParam + " " + surnameStringParam;
    }

}

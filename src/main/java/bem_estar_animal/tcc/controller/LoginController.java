package bem_estar_animal.tcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bem_estar_animal.tcc.model.Login;
import bem_estar_animal.tcc.record.LoginRecord;
import bem_estar_animal.tcc.service.LoginService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/fazerLogin")
public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Login>> getAllLogins() {
        List<Login> loginList = loginService.getAllLogins();
        return ResponseEntity.ok().body(loginList);
    }

    @PostMapping("/criar")
    public ResponseEntity<Login> createLogin(@RequestBody LoginRecord loginRecord) {
        Login login = loginService.createLogin(loginRecord);
        return ResponseEntity.ok().body(login);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Login> updateLogin(@PathVariable Long id, @RequestBody LoginRecord loginRecord) {
        Login login = loginService.updateLogin(id, loginRecord);
        return ResponseEntity.ok().body(login);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLogin(@PathVariable Long id) {
        boolean loginDeleted = loginService.deleteLogin(id);

        if (loginDeleted == false) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok().build();
    }

}

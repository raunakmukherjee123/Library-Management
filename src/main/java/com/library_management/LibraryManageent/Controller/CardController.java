package com.library_management.LibraryManageent.Controller;

import com.library_management.LibraryManageent.Service.CardService;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/card/")
public class CardController
{
  @Autowired
  private CardService cardService;
  @PostMapping("Generate_Card")
  public ResponseEntity addcard()
  {
    String res=cardService.generatecard();
    return new ResponseEntity(res, HttpStatus.OK);
  }
  @PutMapping("AssociateCard&Student")
  public ResponseEntity associate(@RequestParam("cardid")Integer cardid,@RequestParam("studentid")Integer studentid)
  {
     String res=cardService.associate(cardid,studentid);
     return new ResponseEntity<>(res,HttpStatus.OK);
  }
}

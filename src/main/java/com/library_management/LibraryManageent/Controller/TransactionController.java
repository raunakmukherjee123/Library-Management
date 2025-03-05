package com.library_management.LibraryManageent.Controller;

import com.library_management.LibraryManageent.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction/")
public class TransactionController
{
    @Autowired
    TransactionService transactionService;
    @PostMapping("issueBook")
    public String issuebook(@RequestParam("cardid")Integer cardid,@RequestParam("bookid")Integer bookid)
    {
     try {
         String res=transactionService.issueBook(cardid,bookid);
         return res;
     }
     catch (Exception e)
     {
         return e.getMessage();
     }
    }
}

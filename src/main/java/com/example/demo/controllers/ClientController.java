package com.example.demo.controllers;



import java.io.File;
import java.io.FileInputStream;

import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import java.util.Optional;

import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.ClientRepository;
import com.example.demo.entities.Client;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import domaine.Response;
@CrossOrigin("*")
@RestController
@RequestMapping("")
public class ClientController {
	@Autowired ServletContext context;
	@Autowired
	protected ClientRepository CL;
	
	@GetMapping("/clients")
	  public List<Client> getAllclients() {
	     System.out.println("Get all clients...");
	 
	    List<Client> clients = new ArrayList<>();
	    CL.findAll().forEach(clients::add);
	 
	    return clients;
	  }
	 
	 @GetMapping ("/getAll")
	 public ResponseEntity<List<String>> getAll()
	 {
		 List<String> listArt = new ArrayList<String>();
		 String filesPath = context.getRealPath("/Images");
		 File filefolder = new File(filesPath);
		 if (filefolder != null)
		 {
			for (File file :filefolder.listFiles())
			{
				if(!file.isDirectory())
				{
				  String encodeBase64 = null;
				  try {
					  String extension = FilenameUtils.getExtension(file.getName());
					  FileInputStream fileInputStream = new FileInputStream(file);
				      byte[] bytes = new byte[(int)file.length()];
				      fileInputStream.read(bytes);
				      encodeBase64 = Base64.getEncoder().encodeToString(bytes);
				      listArt.add("data:image/"+extension+";base64,"+encodeBase64);
				      fileInputStream.close();
				      
				      
				  }catch (Exception e){
					  
				  }
				}
			}
		 }
		 return new ResponseEntity<List<String>>(listArt,HttpStatus.OK);
	 }
	

	 
	 
	
	 @PostMapping(value = "/saveUser")
	 public ResponseEntity<Response> saveUser (@RequestParam("file") MultipartFile file,
			 @RequestParam("user") String user) throws JsonParseException , JsonMappingException , Exception
	 {
		 Client client = new ObjectMapper().readValue(user, Client.class);
    
		 client.setPhoto(file.getOriginalFilename());
		 Client art =CL.save(client);
     
     if (art != null)
     {
     
    
     	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
     }
     else
     {
     	return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);	
     }
	 }
	 
	 
	 
	 @PostMapping("/clients")
	 public ResponseEntity<Response> create (@RequestParam("file") MultipartFile file,
			 @RequestParam(value="client") String client) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
		 Client arti = new ObjectMapper().readValue(client, Client.class);
     boolean isExit = new File(context.getRealPath("/Images/")).exists();
     if (!isExit)
     {
     	new File (context.getRealPath("/Images/")).mkdir();
     	System.out.println("mkdir.............");
     }
     String filename = file.getOriginalFilename();
     String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
     File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
     try
     {
     	System.out.println("Image");
     	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
     	 
     }catch(Exception e) {
     	e.printStackTrace();
     }

    
     arti.setPhoto(newFileName);
     Client art = CL.save(arti);
     if (art != null)
     {
     	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
     }
     else
     {
     	return new ResponseEntity<Response>(new Response ("Article not saved"),HttpStatus.BAD_REQUEST);	
     }
	 }
	 
	 @GetMapping("/clients/{id}")
		public Client getclientById(@PathVariable Long id)
				 {
		 Optional<Client> c= CL.findById(id);
		 return c.isPresent()?c.get():null;
		 
			
		}
	 
	 @GetMapping(path="/Imgclients/{id}")
	 public byte[] getPhoto(@PathVariable("id") Long id) throws Exception{
		 Client  client   = CL.findById(id).get();
		 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+client.getPhoto()));
	 }
	
	
				

	@DeleteMapping("/clients/{id}")
	public void delete (@PathVariable Long id ) {
		CL.deleteById(id);
	}
	  	 


	  @PutMapping("/clients/{id}")
	  public ResponseEntity<Client> update(@PathVariable("id") long id, @RequestBody Client Client) {
	    System.out.println("Update Article with ID = " + id + "...");
	    Optional<Client> ClientInfo = CL.findById(id);
	    if (ClientInfo.isPresent()) {
	    	Client C = ClientInfo.get();
	           C.setCin(Client.getCin());
	         C.setPhoto(Client.getPhoto());
	         C.setPermis(Client.getPermis());
	         C.setNumtel(Client.getNumtel());
	           C.setUsername(Client.getUsername());
	           C.setFirstname(Client.getFirstname());
	           C.setLastname(Client.getLastname());
	           C.setEmail(Client.getEmail());
	           C.setPassword(Client.getPassword());
	           
	         
	      return new ResponseEntity<>(CL.save(Client), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @GetMapping("/clients/clientnumb")
		public Long numberOfClients(){
	        return CL.count();
	      
	    }  
	  
	  
	  

}
package com.websystique.springmvc.controller;





import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.rememberme.PersistentTokenBasedRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import com.websystique.springmvc.service.UserProfileService;
import com.websystique.springmvc.service.HardwareProfileService;
import com.websystique.springmvc.model.UserProfile;
//import com.websystique.springmvc.model.DepartamentoProfile;


import com.websystique.springmvc.model.User;
import com.websystique.springmvc.model.Bodega;
import com.websystique.springmvc.model.Compras;
import com.websystique.springmvc.model.Asignacion;
import com.websystique.springmvc.model.Prestamo;
import com.websystique.springmvc.model.Estado;
//import com.websystique.springmvc.model.Departamento;
import com.websystique.springmvc.model.Hardware;
import com.websystique.springmvc.service.UserService;
import com.websystique.springmvc.service.BodegaService;
import com.websystique.springmvc.service.ComprasService;
import com.websystique.springmvc.service.AsignacionService;
//import com.websystique.springmvc.service.DepartamentoProfileService;
import com.websystique.springmvc.service.PrestamoService;
import com.websystique.springmvc.service.EstadoService;
//import com.websystique.springmvc.service.DepartamentoService;
import com.websystique.springmvc.service.HardwareService;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


import javax.annotation.Resource;


import javax.persistence.PersistenceUnit;
import org.springframework.context.annotation.Role;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
@SessionAttributes
//@Resource(name = "singleTransactionsService")


public class AppController {

    @Autowired
    UserService userService;
    
    
    
    
        @Autowired
    UserProfileService userProfileService;
        @Autowired
    HardwareProfileService hardwareProfileService;
 
    
    
   @Autowired
   BodegaService bodegaService;
   
   
   @Autowired
   ComprasService comprasService;
   
   
   @Autowired
   AsignacionService asignacionService;
   
   @Autowired
   PrestamoService prestamoService;
   
   
   @Autowired
   EstadoService estadoService;
   
  // @Autowired
  // DepartamentoService departamentoService;
   
   @Autowired
   HardwareService hardwareService;



    @Autowired
    MessageSource messageSource;

    @Autowired
    PersistentTokenBasedRememberMeServices persistentTokenBasedRememberMeServices;

    @Autowired
    AuthenticationTrustResolver authenticationTrustResolver;
   //---Menu------------------------------------------------------------
    @RequestMapping(value = {"/", "/menu"}, method = RequestMethod.GET)
    public String menuApp(ModelMap model) {

       // List<User> users = userService.findAllUsers();
        //model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "menu";
    }
 

//------------------------------------- Usuarios------------------------------------------------------------
      
 //---Listar Usuarios------------------------------------------------------------
    @RequestMapping(value = {"/list"}, method = RequestMethod.GET)
    public String listUsers(ModelMap model) {

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("loggedinuser", getPrincipal());
        return "userslist";
    }
 
//---Registrar Usuario----------------------------------------------------------
    @RequestMapping(value = {"/newuser"}, method = RequestMethod.GET)
    public String newUser(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
    }
 
//---Registrar Usuario Save-----------------------------------------------------

    @RequestMapping(value = {"/newuser"}, method = RequestMethod.POST)
    public String saveUser(@Valid User user, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.isUserUSUUnique(user.getId(), user.getUsuId())) {
            FieldError usuError = new FieldError("user", "usuId", messageSource.getMessage("non.unique.usuId", new String[]{user.getUsuId()}, Locale.getDefault()));
            result.addError(usuError);
            return "registration";
        }

        userService.saveUser(user);

        model.addAttribute("success", "Usuario " + user.getNombre() + " " + user.getApellido() + " Registrado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccess";
    }

//---Editar Usuario-------------------------------------------------------------
    @RequestMapping(value = {"/edit-user-{usuId}"}, method = RequestMethod.GET)
    public String editUser(@PathVariable String usuId, ModelMap model) {
        User user = userService.findByUSU(usuId);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registration";
   }
    
//---Editar Usuarios Save-------------------------------------------------------
    @RequestMapping(value = {"/edit-user-{usuId}"}, method = RequestMethod.POST)
    public String updateUser(@Valid User user, BindingResult result,
            ModelMap model, @PathVariable String usuId) {

        if (result.hasErrors()) {
            return "registration";
        }

        if (!userService.isUserUSUUnique(user.getId(), user.getUsuId())) {
            FieldError usuError = new FieldError("user", "usuId", messageSource.getMessage("non.unique.usuId", new String[]{user.getUsuId()}, Locale.getDefault()));
            result.addError(usuError);
            return "registration";
        }

        userService.updateUser(user);

        model.addAttribute("success", "Usuario " + user.getNombre() + " " + user.getApellido() + " Actualizado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccess";
    }

//---Eliminar Usuario-----------------------------------------------------------
    @RequestMapping(value = {"/delete-user-{usuId}"}, method = RequestMethod.GET)
    public String deleteUser(@PathVariable String usuId) {
        userService.deleteUserByUSU(usuId);
        return "redirect:/list";
    }
    
//----------------------------------Roles Usuario---------------------------
    @ModelAttribute("roles")
    //@Query("Select * from user_profile")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }
  
    
   
    
 
    
//------------------------------------- Bodegas------------------------------------------------------------
//---Bodega Listar--------------------------------------------------------------
    
        @RequestMapping(value = {"/listb"}, method = RequestMethod.GET)
    public String listBodegas(ModelMap model) {

        List<Bodega> bodegas = bodegaService.findAllBodegas();
        model.addAttribute("bodegas", bodegas);
        model.addAttribute("loggedinuser", getPrincipal());
        return "bodegalist";
    }
 
    
    
     
    
//---Registrar Bodega-----------------------------------------------------------
    @RequestMapping(value = {"/newbodega"}, method = RequestMethod.GET)
    public String newBodega(ModelMap model) {
        Bodega bodega = new Bodega();
        model.addAttribute("bodega", bodega);
        model.addAttribute("editB", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationB";
    }
 
//---Registrar Bodega Save------------------------------------------------------

    @RequestMapping(value = {"/newbodega"}, method = RequestMethod.POST)
    public String saveUser(@Valid Bodega bodega, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registrationB";
        }

        if (!bodegaService.isBodegaBODEGUnique(bodega.getId(), bodega.getBodegId())) {
            FieldError bodegError = new FieldError("bodega", "bodegId", messageSource.getMessage("non.unique.bodegId", new String[]{bodega.getBodegId()}, Locale.getDefault()));
            result.addError(bodegError);
            return "registrationB";
        }

        bodegaService.saveBodega(bodega);

        model.addAttribute("success", "El Objeto " + bodega.getBodegId() + " " + bodega.getDescripcion() + " Registrada correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccessB";
    }

//---Editar Bodega--------------------------------------------------------------
    @RequestMapping(value = {"/edit-bodega-{bodegId}"}, method = RequestMethod.GET)
    public String editBodega(@PathVariable String bodegId, ModelMap model) {
        Bodega bodega = bodegaService.findByBODEG(bodegId);
        model.addAttribute("bodega", bodega);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationB";
    }
//---Editar Bodegas Save-------------------------------------------------------
      @RequestMapping(value = {"/edit-bodega-{bodegId}"}, method = RequestMethod.POST)
      
    public String updateBodega(@Valid Bodega bodega, BindingResult result,
            ModelMap model, @PathVariable String bodegId) {

        if (result.hasErrors()) {
            return "registrationB";
        }

        if (!bodegaService.isBodegaBODEGUnique(bodega.getId(), bodega.getBodegId())) {
            FieldError bodegError = new FieldError("bodega", "bodegId", messageSource.getMessage("non.unique.bodegaId", new String[]{bodega.getBodegId()}, Locale.getDefault()));
            result.addError(bodegError);
            return "registrationB";
        }

        bodegaService.updateBodega(bodega);

        model.addAttribute("success", "El Objeto " + bodega.getBodegId() + " " + bodega.getDescripcion() + " Actualizado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccessB";
    }


//---Eliminar Bodega------------------------------------------------------------
    @RequestMapping(value = {"/delete-bodega-{bodegId}"}, method = RequestMethod.GET)
    public String deleteBodega(@PathVariable String bodegId) {
        bodegaService.deleteBodegaByBODEG(bodegId);
        return "redirect:/listb";
    }

    
    

//------------------------------------- Compras------------------------------------------------------------
//---Compras Listar-------------------------------------------------------------
    
        @RequestMapping(value = {"/listc"}, method = RequestMethod.GET)
    public String listCompras(ModelMap model) {

        List<Compras> compras = comprasService.findAllCompras();
        model.addAttribute("compras", compras);
        model.addAttribute("loggedinuser", getPrincipal());
        return "compraslist";
    }
//---Registrar Compras-----------------------------------------------------------
    @RequestMapping(value = {"/newcompras"}, method = RequestMethod.GET)
    public String newCompras(ModelMap model) {
        Compras compras = new Compras();
        model.addAttribute("compras", compras);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationC";
    }
 
//---Registrar Compras Save------------------------------------------------------

    @RequestMapping(value = {"/newcompras"}, method = RequestMethod.POST)
    public String saveCompras(@Valid Compras compras, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registrationC";
        }

        if (!comprasService.isComprasCOMUnique(compras.getId(), compras.getNombreId())) {
            FieldError comError = new FieldError("Compras", "nombreId", messageSource.getMessage("non.unique.nombreId", new String[]{compras.getNombreId()}, Locale.getDefault()));
            result.addError(comError);
            return "registrationC";
        }

        comprasService.saveCompras(compras);

        model.addAttribute("success", "El Objeto " + compras.getNombreId() + " " + compras.getDescripcion() + " Registrada correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccessC";
    }
    
//---Editar Compras--------------------------------------------------------------
    @RequestMapping(value = {"/edit-compras-{nombreId}"}, method = RequestMethod.GET)
    public String editCompras(@PathVariable String nombreId, ModelMap model) {
        Compras compras = comprasService.findByCOM(nombreId);
        model.addAttribute("compras", compras);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationC";
    }
//---Editar Compras Save-------------------------------------------------------
      @RequestMapping(value = {"/edit-compras-{nombreId}"}, method = RequestMethod.POST)
    public String updateCompras(@Valid Compras compras, BindingResult result,
            ModelMap model, @PathVariable String nombreId) {

        if (result.hasErrors()) {
            return "registrationC";
        }

        if (!comprasService.isComprasCOMUnique(compras.getId(), compras.getNombreId())) {
            FieldError comError = new FieldError("compras", "nombreId", messageSource.getMessage("non.unique.nombreId", new String[]{compras.getNombreId()}, Locale.getDefault()));
            result.addError(comError);
            return "registrationC";
        }

        comprasService.updateCompras(compras);

        model.addAttribute("success", "El Objeto " + compras.getNombreId() + " " + compras.getDescripcion() + " Actualizado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccessC";
 }

//---Eliminar Compra------------------------------------------------------------
    @RequestMapping(value = {"/delete-compras-{nombreId}"}, method = RequestMethod.GET)
    public String deleteCompras(@PathVariable String nombreId) {
        comprasService.deleteComprasByCOM(nombreId);
        return "redirect:/listc";
    } 
//------------------------------------- Asignaciones------------------------------------------------------------
//---Asignaciones Listar--------------------------------------------------------------
    
        @RequestMapping(value = {"/lista"}, method = RequestMethod.GET)
    public String listAsignaciones(ModelMap model) {

        List<Asignacion> asignaciones = asignacionService.findAllAsignaciones();
        model.addAttribute("asignaciones", asignaciones);
        model.addAttribute("loggedinuser", getPrincipal());
        return "asignacioneslist";
    }
 

   
//---Registrar Asignaciones-----------------------------------------------------------
    @RequestMapping(value = {"/newasignacion"}, method = RequestMethod.GET)
    public String newAsignacion(ModelMap model) {
        Asignacion asignacion = new Asignacion();
        model.addAttribute("asignacion", asignacion);
        model.addAttribute("edit", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationA";
    }
 
//---Registrar Asignaciones Save------------------------------------------------------

    @RequestMapping(value = {"/newasignacion"}, method = RequestMethod.POST)
    public String saveAsignacion(@Valid Asignacion asignacion, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registrationA";
        }

        if (!asignacionService.isAsignacionASIUnique(asignacion.getId(), asignacion.getAsignacionId())) {
            FieldError asiError = new FieldError("Asignacion", "asignacionId", messageSource.getMessage("non.unique.asignacionId", new String[]{asignacion.getAsignacionId()}, Locale.getDefault()));
            result.addError(asiError);
            return "registrationA";
        }

        asignacionService.saveAsignacion(asignacion);

        model.addAttribute("success", "La Asignacion " + asignacion.getAsignacionId() + " " + asignacion.getUsuarioFk() + " Registrada correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccessA";
    }
    
//---Editar Asignaciones--------------------------------------------------------------
    @RequestMapping(value = {"/edit-asignacion-{asignacionId}"}, method = RequestMethod.GET)
    public String editAsignacion(@PathVariable String asignacionId, ModelMap model) {
        Asignacion asignacion = asignacionService.findByASI(asignacionId);
        model.addAttribute("asignacion", asignacion);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationA";
    }
//---Editar Asignaciones Save-------------------------------------------------------
      @RequestMapping(value = {"/edit-asignacion-{asignacionId}"}, method = RequestMethod.POST)
    public String updateAsignacion(@Valid Asignacion asignacion, BindingResult result,
            ModelMap model, @PathVariable String asignacionId) {

        if (result.hasErrors()) {
            return "registrationA";
        }

        if (!asignacionService.isAsignacionASIUnique(asignacion.getId(), asignacion.getAsignacionId())) {
            FieldError asiError = new FieldError("asignacion", "asignacionId", messageSource.getMessage("non.unique.asignacionId", new String[]{asignacion.getAsignacionId()}, Locale.getDefault()));
            result.addError(asiError);
            return "registrationA";
        }

        asignacionService.updateAsignacion(asignacion);

        model.addAttribute("success", "La Asignacion" + asignacion.getAsignacionId() + " " + asignacion.getUsuarioFk()+ " Actualizado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccessA";
    }
//---Eliminar Asignaciones------------------------------------------------------------
    @RequestMapping(value = {"/delete-asignacion-{asignacionId}"}, method = RequestMethod.GET)
    public String deleteAsignacion(@PathVariable String asignacionId) {
        asignacionService.deleteAsignacionByASI(asignacionId);
        return "redirect:/lista";
    }
    
    
//------------------------------------- Prestamos------------------------------------------------------------
//---Prestamos Listar--------------------------------------------------------------
  
    
         @RequestMapping(value = {"/listp"}, method = RequestMethod.GET)
    public String listPrestamos(ModelMap model) {

        List<Prestamo> prestamos = prestamoService.findAllPrestamos();
        model.addAttribute("prestamos", prestamos);
        model.addAttribute("loggedinuser", getPrincipal());
        return "prestamoslist";
    }
 
//---Registrar Prestamo-----------------------------------------------------------
  
    
    @RequestMapping(value = {"/newprestamo"}, method = RequestMethod.GET)
    public String newPrestamo(ModelMap model){
    Prestamo prestamo = new Prestamo();
    model.addAttribute("prestamo",prestamo);
    model.addAttribute("editP",false);
    model.addAttribute("loggedinuser",getPrincipal());
    return "registrationP";
    }
 
//---Registrar Prestamo Save------------------------------------------------------

    @RequestMapping(value = {"/newprestamo"}, method = RequestMethod.POST)
    public String savePrestamo(@Valid Prestamo prestamo, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registrationP";
        }

        if (!prestamoService.isPrestamoPRESUnique(prestamo.getId(), prestamo.getPrestamoId())) {
            FieldError presError = new FieldError("prestamo", "prestamoId", messageSource.getMessage("non.unique.prestamoId", new String[]{prestamo.getPrestamoId()}, Locale.getDefault()));
            result.addError(presError);
            return "registrationP";
        }

        prestamoService.savePrestamo(prestamo);

        model.addAttribute("success", "El Prestamo" + prestamo.getPrestamoId() + " " + prestamo.getUsuario() + " Registrada correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccessP";
    }
    
//---Editar Prestamos--------------------------------------------------------------
    @RequestMapping(value = {"/edit-prestamo-{prestamoId}"}, method = RequestMethod.GET)
    public String editPrestamo(@PathVariable String prestamoId, ModelMap model) {
        Prestamo prestamo = prestamoService.findByPRES(prestamoId);
        model.addAttribute("prestamo", prestamo);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationP";
    }
//---Editar Prestamo Save-------------------------------------------------------
      @RequestMapping(value = {"/edit-prestamo-{prestamoId}"}, method = RequestMethod.POST)
    public String updatePrestamo(@Valid Prestamo prestamo, BindingResult result,
            ModelMap model, @PathVariable String prestamoId) {

        if (result.hasErrors()) {
            return "registrationP";
        }

        if (!prestamoService.isPrestamoPRESUnique(prestamo.getId(), prestamo.getPrestamoId())) {
            FieldError presError = new FieldError("prestamo", "prestamoId", messageSource.getMessage("non.unique.asignacionId", new String[]{prestamo.getPrestamoId()}, Locale.getDefault()));
            result.addError(presError);
            return "registrationP";
        }

        prestamoService.updatePrestamo(prestamo);

        model.addAttribute("success", "El Prestamo" + prestamo.getPrestamoId() + " " + prestamo.getUsuario()+ " Actualizado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccessP";
    }
    
//---Eliminar Prestamos------------------------------------------------------------
    @RequestMapping(value = {"/delete-prestamo-{prestamoId}"}, method = RequestMethod.GET)
    public String deletePrestamo(@PathVariable String prestamoId) {
        prestamoService.deletePrestamoByPRES(prestamoId);
        return "redirect:/listp";
    }
    
    
        
//------------------------------------- Estados------------------------------------------------------------
//---Estado Listar--------------------------------------------------------------
    
        @RequestMapping(value = {"/liste"}, method = RequestMethod.GET)
    public String listEstados(ModelMap model) {

        List<Estado> estados = estadoService.findAllEstados();
        model.addAttribute("estados", estados);
        model.addAttribute("loggedinuser", getPrincipal());
        return "estadolist";
    }
//---Registrar Estado-----------------------------------------------------------
    @RequestMapping(value = {"/newestado"}, method = RequestMethod.GET)
    public String newEstado(ModelMap model) {
        Estado estado = new Estado();
        model.addAttribute("estado", estado);
        model.addAttribute("editE", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationE";
    }
 
//---Registrar Estado Save------------------------------------------------------

    @RequestMapping(value = {"/newestado"}, method = RequestMethod.POST)
    public String saveEstado(@Valid Estado estado, BindingResult result,
            ModelMap model) {

        if (result.hasErrors()) {
            return "registrationE";
        }

        if (!estadoService.isEstadoESTUnique(estado.getId(), estado.getEstadoId())) {
            FieldError estadoError = new FieldError("estado", "estadoId", messageSource.getMessage("non.unique.estadoId", new String[]{estado.getEstadoId()}, Locale.getDefault()));
            result.addError(estadoError);
            return "registrationE";
        }

        estadoService.saveEstado(estado);

        model.addAttribute("success", "El Estado" + estado.getEstadoId() + " " + estado.getNombreEstado() + " Registrada correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccessE";
    }
//---Editar Estado--------------------------------------------------------------
    @RequestMapping(value = {"/edit-estado-{estadoId}"}, method = RequestMethod.GET)
    public String editEstado(@PathVariable String estadoId, ModelMap model) {
        Estado estado = estadoService.findByEST(estadoId);
        model.addAttribute("estado", estado);
        model.addAttribute("edit", true);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationE";
    }
//---Editar Estado Save-------------------------------------------------------
      @RequestMapping(value = {"/edit-estado-{estadoId}"}, method = RequestMethod.POST)
    public String updateBodega(@Valid Estado estado, BindingResult result,
            ModelMap model, @PathVariable String estadoId) {

        if (result.hasErrors()) {
            return "registrationE";
        }

        if (!estadoService.isEstadoESTUnique(estado.getId(), estado.getEstadoId())) {
            FieldError estError = new FieldError("estado", "estadoId", messageSource.getMessage("non.unique.estadoId", new String[]{estado.getEstadoId()}, Locale.getDefault()));
            result.addError(estError);
            return "registrationE";
        }

        estadoService.updateEstado(estado);

        model.addAttribute("success", "El Estado " + estado.getEstadoId() + " " + estado.getNombreEstado() + " Actualizado correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationsuccessE";
    }

//---Eliminar Estados------------------------------------------------------------
    @RequestMapping(value = {"/delete-estado-{estadoId}"}, method = RequestMethod.GET)
    public String deleteEstado(@PathVariable String estadoId) {
        estadoService.deleteEstadoByEST(estadoId);
        return "redirect:/liste";
    }
    
//------------------------------------- Hardware------------------------------------------------------------
//---Hardware Listar--------------------------------------------------------------
 
       @RequestMapping(value = {"/listh"}, method = RequestMethod.GET)
   public String listHardwares(ModelMap model) {

       List<Hardware> hardwares = hardwareService.findAllhardwares();
       model.addAttribute("hardwares", hardwares);
      model.addAttribute("loggedinuser", getPrincipal());
      return "hardwarelist";
   }
    
//---Registrar Hardware-----------------------------------------------------------
    @RequestMapping(value = {"/newhardware"}, method = RequestMethod.GET)
    public String newHardware(ModelMap model) {
        Hardware hardware = new Hardware();
        model.addAttribute("hardware", hardware);
        model.addAttribute("editH", false);
        model.addAttribute("loggedinuser", getPrincipal());
        return "registrationH";
    }
 
//---Registrar Hardware Save------------------------------------------------------

    @RequestMapping(value = {"/newhardware"}, method = RequestMethod.POST)
    public String saveHardware(@Valid Hardware hardware, BindingResult result,
            ModelMap model) {
        if (result.hasErrors()) {
            return "registrationH";
        }

       if (!hardwareService.isHardwareHARDUnique(hardware.getId(), hardware.getHardwareId())) {
           FieldError hardwareError = new FieldError("hardware", "hardwareId", messageSource.getMessage("non.unique.hardwareId", new String[]{hardware.getHardwareId()}, Locale.getDefault()));
           result.addError(hardwareError);
            return "registrationH";
        }

        hardwareService.saveHardware(hardware);

        model.addAttribute("success", "El Hardware" + hardware.getHardwareId() + " " + hardware.getDescripcion()+ " Registrada correctamente");
        model.addAttribute("loggedinuser", getPrincipal());
        //return "success";
        return "registrationsuccessH";
   }

    
       @ModelAttribute("Hardware")
    public List<Hardware> initializeProfilesh() {
        return hardwareProfileService.findAllh();
    }
    
 
    
//---Eliminar Hardware------------------------------------------------------------
    @RequestMapping(value = {"/delete-hardware-{hardwareId}"}, method = RequestMethod.GET)
    public String deleteHardware(@PathVariable String hardwareId) {
        hardwareService.deleteHardwareByHARD(hardwareId);
        return "redirect:/listh";
    }    
  //Falta Editar 
    
   //---Editar Hardware--------------------------------------------------------------
    @RequestMapping(value = {"/edit-hardware-{hardwareId}"}, method = RequestMethod.GET)
    public String editDepartamento(@PathVariable String hardwareId, ModelMap model) {
        Hardware hardware = hardwareService.findByHARD(hardwareId);
       model.addAttribute("hardware", hardware);
       model.addAttribute("edit", true);
       model.addAttribute("loggedinuser", getPrincipal());
        return "registrationH";
    }
//---Editar Departamento Save-------------------------------------------------------
      @RequestMapping(value = {"/edit-hardwre-{hardwareId}"}, method = RequestMethod.POST)
    public String updateHardware(@Valid Hardware hardware, BindingResult result,
            ModelMap model, @PathVariable String hardwareId) {

        if (result.hasErrors()) {
           return "registrationH";
      }

       if (!hardwareService.isHardwareHARDUnique(hardware.getId(), hardware.getHardwareId())) {
           FieldError hardError = new FieldError("hardware", "hardwareId", messageSource.getMessage("non.unique.hardwareId", new String[]{hardware.getHardwareId()}, Locale.getDefault()));
           result.addError(hardError);
           return "registrationH";
      }

       hardwareService.updateHardware(hardware);
      model.addAttribute("success", "El Hardware " + hardware.getHardwareId()+ " " + hardware.getDescripcion()+ " Actualizado correctamente");
      model.addAttribute("loggedinuser", getPrincipal());
      return "registrationsuccessH";
  }
    
    

    
    
    
    
    //----------------------------------Roles Usuario---------------------------
   // @ModelAttribute("usu")
    //public List<User> initializeUsers() {
      //  return userService.findAllUsers();
   // }
    
    
    
    
    
    
    
    
    
    
    
//--------------------------------Acceso denegado-----------------------------------------------------------	
    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("loggedinuser", getPrincipal());
        return "accessDenied";
    }

//--------------------------------Login-----------------------------------------------------------------	
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        if (isCurrentAuthenticationAnonymous()) {
            return "login";
        } else {
            return "redirect:/list";
        }
    }

//------------------------------LogOut------------------------------------------------------------------	
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {

            persistentTokenBasedRememberMeServices.logout(request, response, auth);
            SecurityContextHolder.getContext().setAuthentication(null);
        }
        return "redirect:/login?logout";
    }

//------------------------------Retorno Principal----------------------------------------------------------------	
    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

//----------------------------Autentificacion Anonymous------------------------------------------------------------------	
    private boolean isCurrentAuthenticationAnonymous() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authenticationTrustResolver.isAnonymous(authentication);
    }
    
    
    
	
		

       

	


	

	

}

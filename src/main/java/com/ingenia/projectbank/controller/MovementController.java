package com.ingenia.projectbank.controller;

import com.ingenia.projectbank.model.*;
import com.ingenia.projectbank.service.BankCardService;
import com.ingenia.projectbank.service.MovementService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class MovementController {
    private final Logger log = LoggerFactory.getLogger(MovementController.class);
    private final MovementService movementService;

    public MovementController(MovementService movementService) {
        this.movementService = movementService;
    }

    /**
     * method return all BankCards
     * @return List<Movements>
     */
    @GetMapping("/movements")
    @ApiOperation(value = "encuentra todas las Movimientos ")
    public List<Movement> findAllMovements(@RequestParam(name = "firstDate", required = false) String startDate,
                                           @RequestParam(name = "finishDate", required = false) String finishDate,
                                           @RequestParam(name = "operation", required = false) OperationType operation,
                                           @RequestParam(name = "category", required = false) CategoryType category,
                                           @RequestParam(name = "payment", required = false) PaymentType payment){
        if(operation!=null){
            log.debug("Rest request for movements filter by operation");
            return movementService.findMovementsByOperation(operation);
        }else if(category!=null){
            log.debug("Rest request for movements filter by category");
            return movementService.findMovementsByCategory(category);
        }else if(payment!=null){
            log.debug("Rest request for movements filter by Payment");
            return movementService.findMovementsByPayment(payment);
        } else if(startDate!=null&&finishDate!=null){
            log.debug("Rest request Movements filter by initDate and finisDate ");
            return movementService.findMovementsInterval( Instant.parse(startDate), Instant.parse(finishDate));
        }
        log.debug("Rest request for Date  Movements");
        return movementService.findAllMovements();
    }

    /**
     *method return One Movement for ID
     * @param id
     * @return
     */
    @GetMapping("/movement/{id}")
    @ApiOperation(value = "encuentra un movimiento por su id")
    public ResponseEntity<Movement> findOneMovement(@ApiParam("Clave primaria del Movimiento") @PathVariable Long id) {
        log.debug("Rest request a Movement with id: "+id);
        Optional<Movement> movementOpt = movementService.findOneMovementById(id);
        if (movementOpt.isPresent())
            return ResponseEntity.ok().body(movementOpt.get());

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * create movement
     * @param movement
     * @return ResponseEntity
     * @throws URISyntaxException
     */
    @PostMapping("/movement")
    @ApiOperation(value = "crea una BankCard")
    public ResponseEntity<Movement> createMovement(@ApiParam("Objeto Movement para Crearlo")@RequestBody Movement movement) throws URISyntaxException{
        log.debug("Create Movement");
        Movement resultado=null;
        if (movement.getId()!=null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        resultado=movementService.createMovement(movement);
        return  ResponseEntity.created(new URI("/api/movement/"+resultado.getId())).body(resultado);
    }

    /**
     * Modify Movement
     * @param movement
     * @return ResponseEntity
     */
    @PutMapping(value = "/movement")
    @ApiOperation(value = "modificar  movimiento")
    public ResponseEntity<Movement> modifyMovement(@ApiParam("Objeto Movement a modificar")@RequestBody Movement movement){
        log.debug("Modify Movement");
        Movement resultado=null;
        if (movement.getId()==null) {
            log.warn("Updating Movement without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        resultado = movementService.updateMovement(movement);
        return ResponseEntity.ok().body(resultado);
    }
    /**
     *method Delete One Movement
     * @param id
     * @return no content
     */
    @DeleteMapping(value = "/movement/{id}")
    @ApiOperation(value = "Borra una movimiento por id")
    public ResponseEntity<Void> deleteOne(@ApiParam("Clave primaria del movimiento")@PathVariable("id") Long id) {
        log.debug("Delete movement");
        movementService.deleteOneMovementById(id);
        return ResponseEntity.noContent().build();
    }
    /**
     * method Delete all  Movementd
     * @return no content
     */
    @ApiOperation(value = "Borra todas las movimientos")
    @DeleteMapping(value = "/movements")
    public ResponseEntity<Void> deleteAll() {
        log.debug("DeleteAll");
        movementService.deleteAllMovements();
        return  ResponseEntity.noContent().build();
    }
}

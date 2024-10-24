package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;
import org.apache.log4j.Logger;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/operators")  // Base URL for the controller
public class OperatorController {

	IOperatorService operatorService;
	private static final Logger logger = Logger.getLogger(OperatorController.class);

	@GetMapping
	public List<Operator> getOperators() {
		logger.info("Fetching all operators");
		return operatorService.retrieveAllOperators();
	}

	@GetMapping("/{operatorId}")
	public Operator retrieveOperator(@PathVariable Long operatorId) {
		logger.info("Fetching operator with ID: " + operatorId);
		return operatorService.retrieveOperator(operatorId);
	}

	@PostMapping
	public Operator addOperator(@RequestBody Operator operator) {
		logger.info("Adding new operator: " + operator);
		return operatorService.addOperator(operator);
	}

	@DeleteMapping("/{operatorId}")
	public void removeOperator(@PathVariable Long operatorId) {
		logger.info("Removing operator with ID: " + operatorId);
		operatorService.deleteOperator(operatorId);
		logger.info("Removed operator with ID: " + operatorId);
	}

	@PutMapping
	public Operator modifyOperateur(@RequestBody Operator operator) {
		logger.info("Updating operator: " + operator);
		return operatorService.updateOperator(operator);
	}
}
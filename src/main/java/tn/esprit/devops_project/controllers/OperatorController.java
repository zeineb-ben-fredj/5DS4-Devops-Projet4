package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

@RestController
@AllArgsConstructor
public class OperatorController {

	private static final Logger logger = LogManager.getLogger(OperatorController.class);

	IOperatorService operatorService;

	@GetMapping("/operator")
	public List<Operator> getOperators() {
		logger.info("Fetching all operators");
		List<Operator> operators = operatorService.retrieveAllOperators();
		logger.info("Fetched {} operators", operators.size());
		return operators;
	}

	@GetMapping("/operator/{operatorId}")
	public Operator retrieveoperator(@PathVariable Long operatorId) {
		logger.info("Fetching operator with ID: {}", operatorId);
		Operator operator = operatorService.retrieveOperator(operatorId);
		logger.info("Fetched operator: {}", operator);
		return operator;
	}

	@PostMapping("/operator")
	public Operator addOperator(@RequestBody Operator operator) {
		logger.info("Adding new operator: {}", operator);
		Operator addedOperator = operatorService.addOperator(operator);
		logger.info("Added operator: {}", addedOperator);
		return addedOperator;
	}

	@DeleteMapping("/operator/{operatorId}")
	public void removeOperator(@PathVariable Long operatorId) {
		logger.info("Removing operator with ID: {}", operatorId);
		operatorService.deleteOperator(operatorId);
		logger.info("Removed operator with ID: {}", operatorId);
	}

	@PutMapping("/operator")
	public Operator modifyOperateur(@RequestBody Operator operator) {
		logger.info("Modifying operator: {}", operator);
		Operator updatedOperator = operatorService.updateOperator(operator);
		logger.info("Modified operator: {}", updatedOperator);
		return updatedOperator;
	}
}

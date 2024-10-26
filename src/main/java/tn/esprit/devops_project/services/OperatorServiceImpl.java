package tn.esprit.devops_project.services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatorServiceImpl implements IOperatorService {

	private static final Logger logger = LogManager.getLogger(OperatorServiceImpl.class);
	OperatorRepository operatorRepository;

	@Override
	public List<Operator> retrieveAllOperators() {
		logger.info("Retrieving all operators");
		List<Operator> operators = (List<Operator>) operatorRepository.findAll();
		logger.info("Retrieved operators: {}", operators);
		return operators;
	}

	@Override
	public Operator addOperator(Operator operator) {
		logger.info("Adding operator: {}", operator);
		Operator addedOperator = operatorRepository.save(operator);
		logger.info("Added operator: {}", addedOperator);
		return addedOperator;
	}

	@Override
	public void deleteOperator(Long id) {
		logger.info("Deleting operator with ID: {}", id);
		operatorRepository.deleteById(id);
		logger.info("Deleted operator with ID: {}", id);
	}

	@Override
	public Operator updateOperator(Operator operator) {
		logger.info("Updating operator: {}", operator);
		Operator updatedOperator = operatorRepository.save(operator);
		logger.info("Updated operator: {}", updatedOperator);
		return updatedOperator;
	}

	@Override
	public Operator retrieveOperator(Long id) {
		logger.info("Retrieving operator with ID: {}", id);
		Operator operator = operatorRepository.findById(id)
				.orElseThrow(() -> {
					logger.error("Operator not found with ID: {}", id);
					return new NullPointerException("Operator not found");
				});
		logger.info("Retrieved operator: {}", operator);
		return operator;
	}
}

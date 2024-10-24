package tn.esprit.devops_project.services;

import org.apache.log4j.Logger;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.Iservices.IOperatorService;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatorServiceImpl implements IOperatorService {

	OperatorRepository operatorRepository;
	private static final Logger logger = Logger.getLogger(OperatorServiceImpl.class);

	@Override
	public List<Operator> retrieveAllOperators() {
		logger.info("Retrieving all operators");
		return (List<Operator>) operatorRepository.findAll();
	}

	@Override
	public Operator addOperator(Operator operator) {
		logger.info("Adding operator: " + operator);
		return operatorRepository.save(operator);
	}

	@Override
	public void deleteOperator(Long id) {
		logger.info("Deleting operator with ID: " + id);
		operatorRepository.deleteById(id);
		logger.info("Deleted operator with ID: " + id);
	}

	@Override
	public Operator updateOperator(Operator operator) {
		logger.info("Updating operator: " + operator);
		return operatorRepository.save(operator);
	}

	@Override
	public Operator retrieveOperator(Long id) {
		logger.info("Retrieving operator with ID: " + id);
		return operatorRepository.findById(id)
				.orElseThrow(() -> {
					logger.error("Operator not found with ID: " + id);
					return new NullPointerException("Operator not found");
				});
	}
}
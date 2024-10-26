package tn.esprit.devops_project.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OperatorServiceImplTest {

    @Mock
    private OperatorRepository operatorRepository; // Mocked repository

    @InjectMocks
    private OperatorServiceImpl operatorService; // Service to be tested

    private Operator operator; // Sample operator for testing

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        operator = new Operator(); // Initialize the operator object
        operator.setIdOperateur(1L);
        operator.setFname("zeineb"); // Set first name
        operator.setLname("benfredj");
    }

    @Test
    public void testRetrieveAllOperators() {
        when(operatorRepository.findAll()).thenReturn(Arrays.asList(operator)); // Mock behavior

        List<Operator> operators = operatorService.retrieveAllOperators(); // Call service method

        assertEquals(1, operators.size()); // Assert that one operator is returned
        verify(operatorRepository).findAll(); // Verify that findAll was called once
    }

    @Test
    public void testRetrieveAllOperatorsWhenEmpty() {
        when(operatorRepository.findAll()).thenReturn(Collections.emptyList()); // Mock empty behavior

        List<Operator> operators = operatorService.retrieveAllOperators(); // Call service method

        assertTrue(operators.isEmpty()); // Assert that the list is empty
        verify(operatorRepository).findAll(); // Verify that findAll was called once
    }

    @Test
    public void testAddOperator() {
        when(operatorRepository.save(any(Operator.class))).thenReturn(operator); // Mock save behavior

        Operator addedOperator = operatorService.addOperator(operator); // Call service method

        assertEquals("zeineb", addedOperator.getFname()); // Check first name
        assertEquals("benfredj", addedOperator.getLname()); // Check last name
        // Assert the name of added operator
        verify(operatorRepository).save(operator); // Verify that save was called with the correct argument
    }

    @Test
    public void testDeleteOperator() {
        doNothing().when(operatorRepository).deleteById(1L); // Mock delete behavior

        operatorService.deleteOperator(1L); // Call service method

        verify(operatorRepository).deleteById(1L); // Verify that deleteById was called with the correct argument
    }
}
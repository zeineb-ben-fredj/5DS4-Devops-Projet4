package tn.esprit.devops_project.repositories;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.devops_project.entities.Operator;

import java.util.Optional;

public class OperatorRepositoryTest {

    @Mock
    private OperatorRepository operatorRepository; // Mocked repository

    private Operator operator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
        operator = new Operator();
        operator.setIdOperateur(1L);
        operator.setFname("zeineb"); // Set first name
        operator.setLname("benfredj");
    }

    @Test
    public void testFindById() {
        when(operatorRepository.findById(1L)).thenReturn(Optional.of(operator)); // Mock behavior

        Optional<Operator> foundOperator = operatorRepository.findById(1L); // Call repository method

        assertTrue(foundOperator.isPresent()); // Assert that the operator is found

        assertEquals("zeineb", foundOperator.get().getFname()); // Check first name
        assertEquals("benfredj", foundOperator.get().getLname()); // Check last name

        verify(operatorRepository).findById(1L); // Verify that findById was called
    }
}
package com.jerikthedog.unitvsintegrationtest.resources;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloControllerTest {

    // https://softwaretestingfundamentals.com/unit-testing/

    // https://martinfowler.com/bliki/UnitTest.html

    /* unit is the smallest testable part of the software
        this is not the controller, but e.g. just the method "hello" in this case
     */

    // a proper unit test
    @Test
    void hello() {
        final var helloController = new HelloController(); // arrange
        final var response = helloController.hello("World"); // act
        assertEquals("Hello, World", response);// assert
    }



}
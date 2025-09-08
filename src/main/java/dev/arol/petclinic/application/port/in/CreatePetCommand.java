package dev.arol.petclinic.application.port.in;

public record CreatePetCommand(String name, String species, String ownerName) {}

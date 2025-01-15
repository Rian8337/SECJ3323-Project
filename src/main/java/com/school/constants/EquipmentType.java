package com.school.constants;

public enum EquipmentType {
    TV_PROGRAM_SHOW("tvProgramShow"),
    SMARTPHONE("smartphone"),
    EXTERNAL_MIC("externalMic"),
    MONOPOD("monopod"),
    RING_LIGHT("ringLight"),
    EDITING_CORNER("editingCorner"),
    WEBCAM("webcam"),
    TRIPOD("tripod"),
    MOBILE_LIGHTING("mobileLighting"),
    MOBILE_GREEN_SCREEN("mobileGreenScreen"),
    OPEN_SOURCE_EDITING_SOFTWARE("editingSoftwareOpenSource"),
    CAMERA("camera"),
    GREEN_SCREEN("greenScreenPermanent"),
    PROFESSIONAL_EDITING_SOFTWARE("editingSoftwarePro");

    public final String label;

    EquipmentType(final String label) {
        this.label = label;
    }
}

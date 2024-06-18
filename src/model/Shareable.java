package model;

public interface Shareable {

    default void share(String phone) {
        // TODO: 14.06.2024 implement sharing logic
        System.out.println("Shared by phone " + phone);
    }

    default void share(String phone, String email) {
        // TODO: 14.06.2024 implement sharing logic
        System.out.println("Shared by phone " + phone + " and by email " + email);
    }
}

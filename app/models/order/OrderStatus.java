/**
 * Copyright HomeOffice Ltda.
 *
 */
package models.order;

/**
 * TODO describe this class
 *
 * @since 2012
 */
public enum OrderStatus {

    // id=0 in the database
    CREATED,
    // id=1 in the database
    NEGOTIATING,
    // id=2 in the database
    PLACED,
    // id=3 in the database
    CANCELLED,
    // id=4 in the database
    EXPIRED,
}

DROP TABLE IF EXISTS rental_event;
DROP TABLE IF EXISTS car;
DROP TABLE IF EXISTS customer;


CREATE TABLE car
(
    id                   INT              NOT NULL,
    brand                VARCHAR(255),
    model                VARCHAR(255),
    build_year           INT              NOT NULL,
    license_plate        VARCHAR(255),
    rental_price_per_day DOUBLE PRECISION NOT NULL,
    available            BOOLEAN          NOT NULL,
    number_of_seats      INT              NOT NULL,
    CONSTRAINT pk_car PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id                    INT NOT NULL,
    first_name            VARCHAR(255),
    last_name             VARCHAR(255),
    email                 VARCHAR(255),
    phone_number          VARCHAR(255),
    driver_license_number VARCHAR(255),
    country_code          VARCHAR(255),
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE rental_event
(
    id                 INT              NOT NULL,
    car_rented_id      INT,
    rental_customer_id INT,
    rental_date        date,
    return_date        date,
    total_cost         DOUBLE PRECISION NOT NULL,
    is_closed          BOOLEAN          NOT NULL,
    CONSTRAINT pk_rentalevent PRIMARY KEY (id)
);

ALTER TABLE rental_event
    ADD CONSTRAINT FK_RENTALEVENT_ON_CAR_RENTED FOREIGN KEY (car_rented_id) REFERENCES car (id);

ALTER TABLE rental_event
    ADD CONSTRAINT FK_RENTALEVENT_ON_RENTAL_CUSTOMER FOREIGN KEY (rental_customer_id) REFERENCES customer (id);

INSERT INTO Car(id,brand,model,build_year,license_plate,rental_price_per_day,available,number_of_seats)
VALUES (1,'Trabant','1.1',1985,'ABV016',2000.0,1,4);
INSERT INTO Car(id,brand,model,build_year,license_plate,rental_price_per_day,available,number_of_seats)
VALUES (2,'Skoda','Favorit',1989,'DSH096',2000.0,0,5);
INSERT INTO Car(id,brand,model,build_year,license_plate,rental_price_per_day,available,number_of_seats)
VALUES (3,'Ford','Escort',1993,'EEF257',4000.0,0,4);

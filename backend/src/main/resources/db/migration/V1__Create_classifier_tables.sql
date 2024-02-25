
CREATE TABLE klassifikaator_vaartus (
                                        id SERIAL PRIMARY KEY,
                                        kood varchar(100) NOT NULL UNIQUE,
                                        vaartus varchar(100) NOT NULL,
                                        keel_kood varchar(100) NOT NULL,
                                        loomis_aeg timestamp NOT NULL,
                                        muutmis_aeg timestamp
);


CREATE TABLE klassifikaator (
                                id SERIAL PRIMARY KEY,
                                domeen_kood varchar(100) NOT NULL,
                                kood varchar(100) NOT NULL UNIQUE,
                                ylem_kood varchar(100),
                                taseme_nr INTEGER NOT NULL,
                                on_ylem_kategooria BOOLEAN NOT NULL,
                                jrk_nr INTEGER,
                                loomis_aeg timestamp NOT NULL,
                                muutmis_aeg timestamp,
                                FOREIGN KEY (ylem_kood) REFERENCES klassifikaator(kood),
                                FOREIGN KEY (kood) REFERENCES klassifikaator_vaartus(kood)
);

CREATE TABLE kasutaja_info (
                          id SERIAL PRIMARY KEY,
                          nimi VARCHAR(255) NOT NULL,
                          on_nous_tingimustega BOOLEAN NOT NULL DEFAULT FALSE,
                          loomis_aeg timestamp NOT NULL,
                          muutmis_aeg timestamp
);

CREATE TABLE kasutaja_sektor (
                            id SERIAL PRIMARY KEY,
                            sektor_kood VARCHAR(100) NOT NULL,
                            kasutaja_id BIGINT NOT NULL,
                            loomis_aeg timestamp NOT NULL,
                            muutmis_aeg timestamp,
                            FOREIGN KEY (kasutaja_id) REFERENCES kasutaja_info(id) ON DELETE CASCADE,
                            FOREIGN KEY (sektor_kood) REFERENCES klassifikaator(kood) ON DELETE CASCADE
);


INSERT INTO klassifikaator_vaartus (kood, vaartus, keel_kood, loomis_aeg) VALUES
                                                                  ('MANUFACTURING', 'Manufacturing', 'EN', now()),
                                                                  ('CONSTRUCTION_MATERIALS', 'Construction materials', 'EN', now()),
                                                                  ('ELECTRONICS_AND_OPTICS', 'Electronics and Optics', 'EN', now()),
                                                                  ('FOOD_AND_BEVERAGE', 'Food and Beverage', 'EN', now()),
                                                                  ('BAKERY_AND_CONFECTIONERY_PRODUCTS', 'Bakery & confectionery products', 'EN', now()),
                                                                  ('BEVERAGES', 'Beverages', 'EN', now()),
                                                                  ('FISH_AND_FISH_PRODUCTS', 'Fish & fish products', 'EN', now()),
                                                                  ('MEAT_AND_MEAT_PRODUCTS', 'Meat & meat products', 'EN', now()),
                                                                  ('MILK_AND_DAIRY_PRODUCTS', 'Milk & dairy products', 'EN', now()),
                                                                  ('FOOD_AND_BEVERAGE_OTHER', 'Other', 'EN', now()),
                                                                  ('SWEETS_AND_SNACK_FOOD', 'Sweets & snack food', 'EN', now()),
                                                                  ('FURNITURE', 'Furniture', 'EN', now()),
                                                                  ('BATHROOM_SAUNA', 'Bathroom/sauna', 'EN', now()),
                                                                  ('BEDROOM', 'Bedroom', 'EN', now()),
                                                                  ('CHILDRENS_ROOM', 'Children’s room', 'EN', now()),
                                                                  ('KITCHEN', 'Kitchen', 'EN', now()),
                                                                  ('LIVING_ROOM', 'Living room', 'EN', now()),
                                                                  ('OFFICE', 'Office', 'EN', now()),
                                                                  ('FURNITURE_OTHER', 'Other (Furniture)', 'EN', now()),
                                                                  ('OUTDOOR', 'Outdoor', 'EN', now()),
                                                                  ('PROJECT_FURNITURE', 'Project furniture', 'EN', now()),
                                                                  ('MACHINERY', 'Machinery', 'EN', now()),
                                                                  ('MACHINERY_COMPONENTS', 'Machinery components', 'EN', now()),
                                                                  ('MACHINERY_EQUIPMENT_TOOLS', 'Machinery equipment/tools', 'EN', now()),
                                                                  ('MANUFACTURE_OF_MACHINERY', 'Manufacture of machinery', 'EN', now()),
                                                                  ('MARITIME', 'Maritime', 'EN', now()),
                                                                  ('ALUMINIUM_AND_STEEL_WORKBOATS', 'Aluminium and steel workboats', 'EN', now()),
                                                                  ('BOAT_YACHT_BUILDING', 'Boat/Yacht building', 'EN', now()),
                                                                  ('SHIP_REPAIR_AND_CONVERSION', 'Ship repair and conversion', 'EN', now()),
                                                                  ('METAL_STRUCTURES', 'Metal structures', 'EN', now()),
                                                                  ('OTHER_MACHINERY', 'Other', 'EN', now()),
                                                                  ('REPAIR_MAINTENANCE_SERVICE', 'Repair and maintenance service', 'EN', now()),
                                                                  ('METALWORKING', 'Metalworking', 'EN', now()),
                                                                  ('HOUSES_AND_BUILDINGS', 'Houses and buildings', 'EN', now()),
                                                                  ('METAL_PRODUCTS', 'Metal products', 'EN', now()),
                                                                  ('METAL_WORKS', 'Metal works', 'EN', now()),
                                                                  ('CNC_MACHINING', 'CNC-machining', 'EN', now()),
                                                                  ('FORGINGS_FASTENERS', 'Forgings, Fasteners', 'EN', now()),
                                                                  ('GAS_PLASMA_LASER_CUTTING', 'Gas, Plasma, Laser cutting', 'EN', now()),
                                                                  ('MIG_TIG_ALUMINUM_WELDING', 'MIG, TIG, Aluminum welding', 'EN', now()),
                                                                  ('PLASTIC_AND_RUBBER', 'Plastic and Rubber', 'EN', now()),
                                                                  ('PACKAGING', 'Packaging', 'EN', now()),
                                                                  ('PLASTIC_GOODS', 'Plastic goods', 'EN', now()),
                                                                  ('PLASTIC_PROCESSING_TECHNOLOGY', 'Plastic processing technology', 'EN', now()),
                                                                  ('BLOWING', 'Blowing', 'EN', now()),
                                                                  ('MOULDING', 'Moulding', 'EN', now()),
                                                                  ('PLASTICS_WELDING_AND_PROCESSING', 'Plastics welding and processing', 'EN', now()),
                                                                  ('PLASTIC_PROFILES', 'Plastic profiles', 'EN', now()),
                                                                  ('PRINTING', 'Printing', 'EN', now()),
                                                                  ('ADVERTISING', 'Advertising', 'EN', now()),
                                                                  ('BOOK_PERIODICALS_PRINTING', 'Book/Periodicals printing', 'EN', now()),
                                                                  ('LABELLING_AND_PACKAGING_PRINTING', 'Labelling and packaging printing', 'EN', now()),
                                                                  ('TEXTILE_AND_CLOTHING', 'Textile and Clothing', 'EN', now()),
                                                                  ('CLOTHING', 'Clothing', 'EN', now()),
                                                                  ('TEXTILE', 'Textile', 'EN', now()),
                                                                  ('WOOD', 'Wood', 'EN', now()),
                                                                  ('OTHER_WOOD', 'Other (Wood)', 'EN', now()),
                                                                  ('WOODEN_BUILDING_MATERIALS', 'Wooden building materials', 'EN', now()),
                                                                  ('WOODEN_HOUSES', 'Wooden houses', 'EN', now()),
                                                                  ('OTHER', 'Other', 'EN', now()),
                                                                  ('CREATIVE_INDUSTRIES', 'Creative industries', 'EN', now()),
                                                                  ('ENERGY_TECHNOLOGY', 'Energy technology', 'EN', now()),
                                                                  ('ENVIRONMENT', 'Environment', 'EN', now()),
                                                                  ('SERVICE', 'Service', 'EN', now()),
                                                                  ('BUSINESS_SERVICES', 'Business services', 'EN', now()),
                                                                  ('ENGINEERING', 'Engineering', 'EN', now()),
                                                                  ('INFORMATION_TECHNOLOGY_AND_TELECOMMUNICATIONS', 'Information Technology and Telecommunications', 'EN', now()),
                                                                  ('DATA_PROCESSING_WEB_PORTALS_E_MARKETING', 'Data processing, Web portals, E-marketing', 'EN', now()),
                                                                  ('PROGRAMMING_CONSULTANCY', 'Programming, Consultancy', 'EN', now()),
                                                                  ('SOFTWARE_HARDWARE', 'Software, Hardware', 'EN', now()),
                                                                  ('TELECOMMUNICATIONS', 'Telecommunications', 'EN', now()),
                                                                  ('TOURISM', 'Tourism', 'EN', now()),
                                                                  ('TRANSLATION_SERVICES', 'Translation services', 'EN', now()),
                                                                  ('TRANSPORT_AND_LOGISTICS', 'Transport and Logistics', 'EN', now()),
                                                                  ('AIR', 'Air', 'EN', now()),
                                                                  ('RAIL', 'Rail', 'EN', now()),
                                                                  ('ROAD', 'Road', 'EN', now()),
                                                                  ('WATER', 'Water', 'EN', now()) ON CONFLICT DO NOTHING
;





INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MANUFACTURING', NULL, 1, true, 1, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'CONSTRUCTION_MATERIALS', 'MANUFACTURING', 2, false, 2, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'ELECTRONICS_AND_OPTICS', 'MANUFACTURING', 2, false, 3, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'FOOD_AND_BEVERAGE', 'MANUFACTURING', 2, false, 4, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BAKERY_AND_CONFECTIONERY_PRODUCTS', 'FOOD_AND_BEVERAGE', 3, false, 5, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BEVERAGES', 'FOOD_AND_BEVERAGE', 3, false, 6, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'FISH_AND_FISH_PRODUCTS', 'FOOD_AND_BEVERAGE', 3, false, 7, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MEAT_AND_MEAT_PRODUCTS', 'FOOD_AND_BEVERAGE', 3, false, 8, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MILK_AND_DAIRY_PRODUCTS', 'FOOD_AND_BEVERAGE', 3, false, 9, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'SWEETS_AND_SNACK_FOOD', 'FOOD_AND_BEVERAGE', 3, false, 10, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'FOOD_AND_BEVERAGE_OTHER', 'FOOD_AND_BEVERAGE', 3, false, 11, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'FURNITURE', 'MANUFACTURING', 2, false, 12, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BATHROOM_SAUNA', 'FURNITURE', 3, false, 13, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BEDROOM', 'FURNITURE', 3, false, 14, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'CHILDRENS_ROOM', 'FURNITURE', 3, false, 15, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'KITCHEN', 'FURNITURE', 3, false, 16, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'LIVING_ROOM', 'FURNITURE', 3, false, 17, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'OFFICE', 'FURNITURE', 3, false, 18, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'OUTDOOR', 'FURNITURE', 3, false, 19, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PROJECT_FURNITURE', 'FURNITURE', 3, false, 20, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'FURNITURE_OTHER', 'FURNITURE', 3, false, 21, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MACHINERY', 'MANUFACTURING', 2, false, 22, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MACHINERY_COMPONENTS', 'MACHINERY', 3, false, 23, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MACHINERY_EQUIPMENT_TOOLS', 'MACHINERY', 3, false, 24, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MANUFACTURE_OF_MACHINERY', 'MACHINERY', 3, false, 25, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MARITIME', 'MACHINERY', 3, false, 26, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'ALUMINIUM_AND_STEEL_WORKBOATS', 'MARITIME', 4, false, 27, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BOAT_YACHT_BUILDING', 'MARITIME', 4, false, 28, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'SHIP_REPAIR_AND_CONVERSION', 'MARITIME', 4, false, 29, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'METAL_STRUCTURES', 'MACHINERY', 3, false, 30, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'OTHER_MACHINERY', 'MACHINERY', 3, false, 31, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'REPAIR_MAINTENANCE_SERVICE', 'MACHINERY', 3, false, 32, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'METALWORKING', 'MANUFACTURING', 2, false, 33, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'METAL_STRUCTURES', 'METALWORKING', 3, false, 34, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'HOUSES_AND_BUILDINGS', 'METALWORKING', 3, false, 35, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'METAL_PRODUCTS', 'METALWORKING', 3, false, 36, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'METAL_WORKS', 'METALWORKING', 3, false, 37, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'CNC_MACHINING', 'METAL_WORKS', 4, false, 38, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'FORGINGS_FASTENERS', 'METAL_WORKS', 4, FALSE, 39, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'GAS_PLASMA_LASER_CUTTING', 'METAL_WORKS', 4, FALSE, 40, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MIG_TIG_ALUMINUM_WELDING', 'METAL_WORKS', 4, FALSE, 41, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PLASTIC_AND_RUBBER', 'MANUFACTURING', 2, FALSE, 42, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PACKAGING', 'PLASTIC_AND_RUBBER', 3, FALSE, 43, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PLASTIC_GOODS', 'PLASTIC_AND_RUBBER', 3, FALSE, 44, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PLASTIC_PROCESSING_TECHNOLOGY', 'PLASTIC_AND_RUBBER', 3, FALSE, 45, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BLOWING', 'PLASTIC_PROCESSING_TECHNOLOGY', 4, FALSE, 46, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'MOULDING', 'PLASTIC_PROCESSING_TECHNOLOGY', 4, FALSE, 47, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PLASTICS_WELDING_AND_PROCESSING', 'PLASTIC_PROCESSING_TECHNOLOGY', 4, FALSE, 48, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PLASTIC_PROFILES', 'PLASTIC_AND_RUBBER', 3, FALSE, 49, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PRINTING', 'MANUFACTURING', 2, FALSE, 50, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'ADVERTISING', 'PRINTING', 3, FALSE, 51, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BOOK_PERIODICALS_PRINTING', 'PRINTING', 3, FALSE, 52, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'LABELLING_AND_PACKAGING_PRINTING', 'PRINTING', 3, FALSE, 53, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'TEXTILE_AND_CLOTHING', 'MANUFACTURING', 2, FALSE, 54, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'CLOTHING', 'TEXTILE_AND_CLOTHING', 3, FALSE, 55, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'TEXTILE', 'TEXTILE_AND_CLOTHING', 3, FALSE, 56, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'WOOD', 'MANUFACTURING', 2, FALSE, 57, now()) ON CONFLICT DO NOTHING
;;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'WOODEN_BUILDING_MATERIALS', 'WOOD', 3, FALSE, 58, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'WOODEN_HOUSES', 'WOOD', 3, FALSE, 59, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'OTHER_WOOD', 'WOOD', 3, FALSE, 60, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'OTHER', NULL, 1, true, 61, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'CREATIVE_INDUSTRIES', 'OTHER', 2, FALSE, 62, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'ENERGY_TECHNOLOGY', 'OTHER', 2, FALSE, 63, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'ENVIRONMENT', 'OTHER', 2, FALSE, 64, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'SERVICE', NULL, 1, true, 65, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'BUSINESS_SERVICES', 'SERVICE', 2, FALSE, 66, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'ENGINEERING', 'SERVICE', 2, FALSE, 67, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'INFORMATION_TECHNOLOGY_AND_TELECOMMUNICATIONS', 'SERVICE', 2, FALSE, 68, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'DATA_PROCESSING_WEB_PORTALS_E_MARKETING', 'INFORMATION_TECHNOLOGY_AND_TELECOMMUNICATIONS', 3, FALSE, 69, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'PROGRAMMING_CONSULTANCY', 'INFORMATION_TECHNOLOGY_AND_TELECOMMUNICATIONS', 3, FALSE, 70, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'SOFTWARE_HARDWARE', 'INFORMATION_TECHNOLOGY_AND_TELECOMMUNICATIONS', 3, FALSE, 71, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'TELECOMMUNICATIONS', 'INFORMATION_TECHNOLOGY_AND_TELECOMMUNICATIONS', 3, FALSE, 72, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'TOURISM', 'SERVICE', 2, FALSE, 73, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'TRANSLATION_SERVICES', 'SERVICE', 2, FALSE, 74, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'TRANSPORT_AND_LOGISTICS', 'SERVICE', 2, FALSE, 75, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'AIR', 'TRANSPORT_AND_LOGISTICS', 3, FALSE, 76, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'RAIL', 'TRANSPORT_AND_LOGISTICS', 3, FALSE, 77, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'ROAD', 'TRANSPORT_AND_LOGISTICS', 3, FALSE, 78, now()) ON CONFLICT DO NOTHING
;
INSERT INTO klassifikaator (domeen_kood, kood, ylem_kood, taseme_nr, on_ylem_kategooria, jrk_nr, loomis_aeg) VALUES ('INDUSTRY', 'WATER', 'TRANSPORT_AND_LOGISTICS', 3, FALSE, 79, now()) ON CONFLICT DO NOTHING
;

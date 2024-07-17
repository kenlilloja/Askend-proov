CREATE TABLE classifier_value (
                                  id SERIAL PRIMARY KEY,
                                  code VARCHAR(100) NOT NULL UNIQUE,
                                  value VARCHAR(100) NOT NULL,
                                  lang_code VARCHAR(100) NOT NULL,
                                  created_at TIMESTAMP NOT NULL,
                                  modified_at TIMESTAMP NOT NULL
);


CREATE TABLE classifier (
                            id SERIAL PRIMARY KEY,
                            domain_code VARCHAR(100) NOT NULL,
                            code VARCHAR(100) NOT NULL UNIQUE,
                            parent_code VARCHAR(100),
                            created_at TIMESTAMP NOT NULL,
                            modified_at TIMESTAMP NOT NULL,
                            FOREIGN KEY (parent_code) REFERENCES classifier(code),
                            FOREIGN KEY (code) REFERENCES classifier_value(code)
);


CREATE TABLE criteria (
                          id SERIAL PRIMARY KEY,
                          filter_id INTEGER,
                          criteria_type VARCHAR(100) NOT NULL,
                          condition VARCHAR(100) NOT NULL,
                          value TEXT NOT NULL,
                          is_selected BOOLEAN NOT NULL DEFAULT FALSE,
                          created_at TIMESTAMP NOT NULL,
                          modified_at TIMESTAMP NOT NULL
);


CREATE TABLE filter (
                        id SERIAL PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        created_at TIMESTAMP NOT NULL,
                        modified_at TIMESTAMP NOT NULL
);

ALTER TABLE criteria ADD FOREIGN KEY (filter_id) REFERENCES filter(id);
ALTER TABLE criteria ADD FOREIGN KEY (criteria_type) REFERENCES classifier(code);
ALTER TABLE criteria ADD FOREIGN KEY (condition) REFERENCES classifier(code);

-- Indexes for classifier_value table
CREATE INDEX idx_classifier_value_code ON classifier_value (code);
CREATE INDEX idx_classifier_value_lang_code ON classifier_value (lang_code);

-- Indexes for classifier table
CREATE INDEX idx_classifier_domain_code ON classifier (domain_code);
CREATE INDEX idx_classifier_code ON classifier (code);
CREATE INDEX idx_classifier_parent_code ON classifier (parent_code);

-- Indexes for criteria table
CREATE INDEX idx_criteria_filter_id ON criteria (filter_id);
CREATE INDEX idx_criteria_criteria_type ON criteria (criteria_type);
CREATE INDEX idx_criteria_condition ON criteria (condition);

-- Indexes for filter table

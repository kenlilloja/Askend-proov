
INSERT INTO classifier_value (code, value, created_at, modified_at) VALUES
       ('CRITERIA_TYPE_AMOUNT', 'Amount', now(), now()),
       ('CRITERIA_TYPE_DATE', 'Date', now(), now()),
       ('CRITERIA_TYPE_TITLE', 'Title', now(), now()),
       ('CRITERIA_COMPARISON_MORE', 'More than', now(), now()),
       ('CRITERIA_COMPARISON_LESS', 'Less than', now(), now()),
       ('CRITERIA_COMPARISON_EQUAL', 'Equals', now(), now()),
       ('CRITERIA_COMPARISON_FROM', 'From', now(), now()),
       ('CRITERIA_COMPARISON_UNTIL', 'Until', now(), now()),
       ('CRITERIA_COMPARISON_AT_THIS_TIME', 'Exactly at ', now(), now()),
       ('CRITERIA_COMPARISON_STARTS_WITH', 'Starts with', now(), now()),
       ('CRITERIA_COMPARISON_ENDS_WITH', 'Ends with', now(), now()),
       ('CRITERIA_COMPARISON_IS_LIKE', 'Exactly like', now(), now());


INSERT INTO classifier (domain_code, code, parent_code, created_at, modified_at) VALUES
       ('CRITERIA_TYPE', 'CRITERIA_TYPE_AMOUNT', null, now(), now()),
       ('CRITERIA_TYPE', 'CRITERIA_TYPE_DATE', null, now(), now()),
       ('CRITERIA_TYPE', 'CRITERIA_TYPE_TITLE', null, now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_MORE', 'CRITERIA_TYPE_AMOUNT', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_LESS', 'CRITERIA_TYPE_AMOUNT', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_EQUAL', 'CRITERIA_TYPE_AMOUNT', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_FROM', 'CRITERIA_TYPE_DATE', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_UNTIL', 'CRITERIA_TYPE_DATE', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_AT_THIS_TIME', 'CRITERIA_TYPE_DATE', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_STARTS_WITH', 'CRITERIA_TYPE_TITLE', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_ENDS_WITH', 'CRITERIA_TYPE_TITLE', now(), now()),
       ('CRITERIA_COMPARISON', 'CRITERIA_COMPARISON_IS_LIKE', 'CRITERIA_TYPE_TITLE', now(), now());
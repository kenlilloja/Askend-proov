
INSERT INTO classifier_value (code, value, lang_code, created_at, modified_at) VALUES
       ('CRITERIA_TYPE_AMOUNT', 'Amount', 'EN', now(), now()),
       ('CRITERIA_TYPE_DATE', 'Date', 'EN', now(), now()),
       ('CRITERIA_TYPE_TITLE', 'Title', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_MORE', 'More than', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_LESS', 'Less than', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_EQUAL', 'Equals', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_FROM', 'From', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_UNTIL', 'Until', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_AT_THIS_TIME', 'Exactly at ', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_STARTS_WITH', 'Starts with', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_ENDS_WITH', 'Ends with', 'EN', now(), now()),
       ('CRITERIA_COMPARISON_IS_LIKE', 'Exactly like', 'EN', now(), now());


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
INSERT INTO filter (name,  created_at, modified_at) VALUES ('Test Filter12', now(), now());


INSERT INTO criteria (filter_id, criteria_type, condition, value, is_selected, created_at, modified_at)
VALUES
    (
        (SELECT id FROM filter WHERE name = 'Test Filter12'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_TYPE_AMOUNT'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_COMPARISON_LESS'),
        '5225',
        true,
        now(),
        now()
    ),
    (
        (SELECT id FROM filter WHERE name = 'Test Filter12'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_TYPE_AMOUNT'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_COMPARISON_MORE'),
        '5200',
        false,
        now(),
        now()
    );


INSERT INTO filter (name,  created_at, modified_at) VALUES ('Filter for testing', now(), now());


INSERT INTO criteria (filter_id, criteria_type, condition, value, is_selected, created_at, modified_at)
VALUES
    (
        (SELECT id FROM filter WHERE name = 'Filter for testing'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_TYPE_TITLE'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_COMPARISON_STARTS_WITH'),
        'Tere',
        true,
        now(),
        now()
    ),
    (
        (SELECT id FROM filter WHERE name = 'Filter for testing'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_TYPE_TITLE'),
        (SELECT code FROM classifier WHERE code = 'CRITERIA_COMPARISON_ENDS_WITH'),
        'Tulemast',
        false,
        now(),
        now()
    );


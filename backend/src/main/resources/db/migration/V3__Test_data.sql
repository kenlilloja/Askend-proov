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
        '1',
        false,
        now(),
        now()
    );

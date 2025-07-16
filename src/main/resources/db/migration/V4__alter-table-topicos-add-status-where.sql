UPDATE topicos SET status = 'NAO_RESPONDIDO' WHERE status = '0';
UPDATE topicos SET status = 'RESPONDIDO' WHERE status = '1';
INSERT INTO `T_SYSPARA` (`UUID`, `CODE`, `PARTY_ID`, `SVALUE`, `SORDER`, `STYPE`, `NOTES`, `MODIFY`, `BAG_TYPE`) VALUES ('withdraw_limit_max3', 'withdraw_limit_max3', NULL, '1000', 100, 2, '支付宝单次最高提现金额', 0, 0);
INSERT INTO `T_SYSPARA` (`UUID`, `CODE`, `PARTY_ID`, `SVALUE`, `SORDER`, `STYPE`, `NOTES`, `MODIFY`, `BAG_TYPE`) VALUES ('withdraw_limit3', 'withdraw_limit3', NULL, '20', 100, 2, '支付宝提现最低金额', 0, 0);
UPDATE `T_SYSPARA` SET `NOTES` = '微信提现最低金额' WHERE `UUID` = 'withdraw_limit2';
UPDATE `T_SYSPARA` SET `NOTES` = '微信单次最高提现金额' WHERE `UUID` = 'withdraw_limit_max2';
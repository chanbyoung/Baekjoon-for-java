SELECT p.price, count(p.price) as PRODUCTS
FROM (SELECT FLOOR(PRICE/10000) * 10000 price
      FROM PRODUCT) p
group by p.price
order by p.price 
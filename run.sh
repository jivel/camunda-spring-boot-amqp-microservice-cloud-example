#!/bin/sh
orderId=1
while :
do
  curl -X POST --header 'Content-Type: application/json' --header 'Accept: */*' 'http://localhost:8080/order?orderId=unaOrden&amount=102'
done

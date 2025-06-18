#!/bin/bash

# Simple Interest = (P × R × T)/100

echo "Enter Principal amount:"
read p
echo "Enter Rate of Interest:"
read r
echo "Enter Time (in years):"
read t

si=$(( (p * r * t) / 100 ))
echo "Simple Interest is: $si"

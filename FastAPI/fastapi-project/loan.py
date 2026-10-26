from fastapi import FastAPI
from pydantic import BaseModel

app=FastAPI()

class Loan(BaseModel):
    age:int
    income:float
    emp_years:int
    loan_amount:float

@app.post("/predict")
def predict(application:Loan):
    if(application.income>5000 and application.age>20):
        decision="aproved"
    else:
        decision="rejected"
    return{
        "application.age":application.age,
        "decision":decision

    }
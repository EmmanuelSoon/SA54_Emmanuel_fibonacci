import {React, Component} from 'react';
import {Form, FormLabel, FormGroup, FormControl, Button} from 'react-bootstrap';

import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

class App extends Component {

  defaultData = {
    fibonacci : [],
    sorted : []
  }

  constructor(props) {
    super(props);
    this.state = {
      elements: '',
      fibonacci : [],
      sorted : []
    };
    this.handleSubmit = this.handleSubmit.bind(this); 
  }
  
  async handleSubmit(event){
    event.preventDefault();
    const elements = this.state;

    const data = await (await fetch(`/fibonacci/submit`, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(elements)
    })).json();

    this.setState({fibonacci: data.fibonacci, sorted: data.sorted});
  }





  render(){
    const {fibonacci, sorted} = this.state;
    
    const fiboList = fibonacci.map((number, i) => {
      if(i !== fibonacci.length-1){
        return (
          <div>{number}, </div>

        );
      }
      else{
        return (
          <div>{number}</div>
        );
      }
    })

    const sortedList = sorted.map((number, i) => {
      if(i !== sorted.length-1){
        return (
          <div>{number}, </div>

        );
      }
      else{
        return (
          <div>{number}</div>
        );
      }
    })


    return (
      <div className="container">
        <h1 className='my-5'>Fibonacci Sequences</h1>
        <div className='row'>
          <Form onSubmit={this.handleSubmit} >
            <FormGroup className='col-sm-12 col-md-6 mb-5'>
              <FormLabel>Pick a Number (From 1 to 100): </FormLabel>
              <FormControl type="number" value={this.state.elements} onChange={(event) => this.setState({elements: event.target.value})}></FormControl>
            </FormGroup>

            <Button type="submit">Submit</Button>
          </Form>
        </div>
        <div className='row my-5'>
          <h1>Results</h1>
          <div className='d-flex'>
            Fibonacci: [{fiboList}]
          </div>
          <div className='d-flex'>
            Sorted List: [{sortedList}]
          </div>
        </div>
      </div>
    );
  }

}

export default App;

import React, {useState, useEffect} from "react";
import ReactDOM from 'react-dom';
import Todo from './Todo';
import NewTodo from './NewTodo';
import Additions from "./Additions";

const Todolist = () => {
    const initialTodos = [
        {
            "title": "Give dog a bath",
            "completeTime": new Date('2021-01-04')
        }, {
            "title": "Do laundry",
            "completeTime": new Date('2021-01-02')
        }, {
            "title": "Vacuum floor",
            "completeTime": new Date('2021-02-10')
        }, {
            "title": "Feed cat",
            "completeTime": new Date('2021-01-01')
        }, {
            "title": "Change light bulbs",
            "completeTime": new Date('2021-01-08')
        }, {
            "title": "Go to Store",
            "completeTime": new Date('2021-04-01')
        }];

    const [Todos, setTodos] = useState(initialTodos);

    // useEffect(() => {
        // let cpy = [...Todos];
    //     cpy.sort((a, b) => (a.completeTime > b.completeTime) ? 1 : -1);
    //     // console.log("1");
    //     // console.log(cpy);
    //     // console.log(Todos);
    //     if(cpy.join()!==Todos.join())
    //     {
    //         // console.log("2");
    //         setTodos(cpy);
    //     }
    //     // console.log("change happened!");
    //     Todos.sort((a, b) => (a.completeTime > b.completeTime) ? 1 : -1)
    //     setTodos(Todos);
    //     // forceUpdate();
    //     // console.log(Todos);
    // },[Todos]);

    
    const addTodo = (userInput,userDate) => {
        // setTodos([...Todos,{title:userInput,completeTime:new Date(userDate)}]);
        let cpy = [...Todos,{title:userInput,completeTime:new Date(userDate)}];
        cpy.sort((a, b) => (a.completeTime > b.completeTime) ? 1 : -1)
        setTodos(cpy);
        // console.log(Todos);
    };

    const deleteTodo = (todo) => {
        // console.log("delete!");
        // console.log(todo);
        let newList = Todos.filter(t => {
            return t.title!==todo.title;
        });
        setTodos(newList);
    };

        return(
            <div>
                <NewTodo addTodo={addTodo}/>
                <Additions Todos={Todos.length}/>
                {/* <Additions Todos={Todos}/> */}
                {/* <h1>TODOS</h1> */}
                <div>
                    {Todos.map((todo) => {
                        // console.log(todo);
                        return (
                            <Todo todo={todo} deleteTodo={deleteTodo}/>
                        );
                    })}
                </div>
            </div>
        );
};

export default Todolist;

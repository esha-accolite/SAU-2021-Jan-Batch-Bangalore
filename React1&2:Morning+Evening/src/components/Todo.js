import React from 'react';

const Todo = ({todo, deleteTodo}) => {
    const {title, completeTime} = todo;
    const del = () => {
        // console.log("del");
        deleteTodo(todo);
        // console.log(todo);
    };
    return (
        <ul>
            <li>
                <p>{title} <button onClick={del}>x</button></p> 
                {/* <p>{completeTime}</p>  */}
                {todo.completeTime.toString()}
                <hr />
            </li>
        </ul>
    );
};

export default Todo;
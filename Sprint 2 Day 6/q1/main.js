import { Todo } from './todo.js';
import { log, renderList } from './utils.js';

const input = document.getElementById('todo-input');
const addBtn = document.getElementById('add-btn');
const todoList = document.getElementById('todo-list');

const defaultTitles = Array.of("Learn ES6", "Write To-Do App", "Test features");
let todos = Array.from(defaultTitles, title => new Todo(title));

const idGen = function* () {
  let i = todos.length + 1;
  while (true) yield i++;
}();
const getId = () => idGen.next().value;

const updateDOM = () => {
  todoList.innerHTML = '';
  for (const todo of todos) {
    const li = document.createElement('li');
    const { title, done } = todo.data;
    li.textContent = `${done ? '✅' : '⬜'} ${title}`;
    if (done) li.classList.add('done');

    li.onclick = () => {
      todo.toggle();
      updateDOM();
    };

    const delBtn = document.createElement('button');
    delBtn.textContent = "Delete";
    delBtn.style.marginLeft = "10px";
    delBtn.onclick = e => {
      e.stopPropagation();
      todos = todos.filter(t => !Object.is(t.data.title, todo.data.title)); 
      updateDOM();
    };

    li.appendChild(delBtn);
    todoList.appendChild(li);
  }
};

const addTodo = () => {
  const text = input.value.trim();
  if (!text) return;
  todos = [...todos, new Todo(`${getId()}. ${text}`)];
  input.value = '';
  updateDOM();
};

addBtn.addEventListener('click', addTodo);

const saveTodos = () =>
  new Promise(resolve => setTimeout(() => resolve("Tasks saved to server."), 1000));

saveTodos().then(log);
updateDOM();

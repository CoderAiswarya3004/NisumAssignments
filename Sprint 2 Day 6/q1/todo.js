const _id = Symbol("id");
const todoStore = new WeakMap();

export class Todo {
  constructor(title = "Untitled") {
    const id = Date.now();
    todoStore.set(this, {
      [_id]: id,
      title,
      done: false
    });
  }

  toggle = () => {
    const data = todoStore.get(this);
    data.done = !data.done;
  };

  get data() {
    return todoStore.get(this);
  }
}

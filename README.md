# Java-SE-concurrency

# Topics

## What is a thread?
Thread is defined at the Operating system level.
Thread is a set of instructions, an application can be composed of multiple threads and different threads can we executed "at the same" time.

To run things concurrently, we need to run threads on different CPU cores of the same machine (multicore CPU) or different machines.

This task of assigning threads to different CPU core is done using a thread scheduler by the OS.

### Challenges: 
- Race condition
- Reentrant lock: A reentrant lock is one where a process can claim the lock multiple times without blocking on itself.
- Deadlocks

### States of a thread
![thread_states.png](..%2F..%2F..%2FDownloads%2Fthread_states.png)
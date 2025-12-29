/*
	interface funcional genérica
	retorna o resultado boolen
*/
interface SomeTest<T>{
	boolean test(T n, T m); 
	//compativel com qualquer expressao lambda
	//que use dois parametros do mesmo tipo e retorne um boolean
}
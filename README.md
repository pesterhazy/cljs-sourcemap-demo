This repo is a reproduction of an issue when ClojureScript compiler doesn't use sourcemaps with `:optimizations` option is set to `:simple`.

### Steps to reproduce

Run the following command. It will build the `*.cljs` file without the optimizations:

```
lein dev && node compiled/first.js
```

This will produce a stacktrace mentioning the `*.cljs` files (full output can be seen at [output-dev.txt](output-dev.txt)):

```
[object Object]
    at Function.demo$first$_main (.../compiled/first.out/demo/first.cljs:4:11)
```

Then run the same command with optimizations enabled

```
lein prod && node compiled/first.js
```

This will produce a stacktrace not mentioning the `*.cljs` files  (full output can be seen at [output-prod.txt](output-prod.txt)):

```
Trace
    at Function.demo.first._main (.../compiled/first.js:2084:353)
    ...
```

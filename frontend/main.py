from bottle import route, run, static_file


@route('/')
@route('/index.html')
def index():
    return static_file("index.html", root="./app/")


@route('/css/:path#.+#')
def static(path):
    return static_file(path, root='./app/css/')


run(host='localhost', port=8080, debug=True, reloader=True)

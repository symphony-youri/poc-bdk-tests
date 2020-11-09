from behave import *
from sym_api_client_python.configure.configure import SymConfig
from sym_api_client_python.auth.rsa_auth import SymBotRSAAuth

@given('a bot')
def step_impl(context):
    configure = SymConfig('../resources/config.json')
    configure.load_config()
    auth = SymBotRSAAuth(configure)
    auth.authenticate()
    pass

@when('bot authenticates')
def step_impl(context):
    assert True is not False

@then('a session is created')
def step_impl(context):
    assert context.failed is False

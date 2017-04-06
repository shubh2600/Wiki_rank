import requests
from bs4 import BeautifulSoup
import json
from io import StringIO
global l
l =[]
global common_words
common_words = ['a','able','about','across','after','all','almost','also',
                'am','among','an','and','any','are','as','at','be','because',
                'been','but','by','can','cannot','could','dear','did','do',
                'does','either','else','ever','every','for','from','get','got',
                'had','has','have','he','her','hers','him','his','how','however',
                'i','if','in','into','is','it','its','just','least','let','like',
                'likely','may','me','might','most','must','my','neither','no','nor',
                'not','of','off','often','on','only','or','other','our','out','own',
                'rather','said','say','says','she','should','since','so','some',
                'such','than','that','the','their','them','then','there','these',
                'they','this','to','too','us','wants','was','we','were','what',
                'when','where','which','while','who','whom','why','will','with',
                'would','yet','you','your']
global common_symbols
common_symbols=['~','!','@','#','$','"','%','^','&','*','(',')','-','-','_','=','+','}','{',']','[',';',':',"'",',','.','<','>','?','/','`']

def start(url):
    word_list = []

    source_code = requests.get(url).text
    soup = BeautifulSoup(source_code,"html5lib")

    for post_text in soup.findAll('div',{'id':'mw-content-text'}):

        for post_tex in post_text.findAll("p"):
                content =post_tex.getText()

                words = content.lower().split()
                for each_word in words:
                    word_list.append(each_word)
    clean_up_list(word_list)



def clean_up_list(word_list):
    clean_word_list = []
    for j in range(0, len(word_list)):

        for i in range(0, len(common_symbols)):

                word = word_list[j].replace(common_symbols[i], "")

        for i in range(0, len(common_words)):
            if word_list[j] == common_words[i]:
                word = word_list[j].replace(common_words[i], "")

        if len(word) > 0:
            clean_word_list.append(word)
    create_dictionary(clean_word_list)

def create_dictionary(clean_word_list):
    with open('test.json') as data_file:
        data = json.load(data_file)
        buf = StringIO()

        buf.write(data['Keyword'])

        d = buf.getvalue()


    word_count = {}

    word_count[d] = 0

    for word in clean_word_list:
        if d == word:
            if word in word_count:
                word_count[word] += 1
            else:
                word_count[word] = 1

    print(word_count[d])
    l.append(word_count[d])
    create_rank(l)


def create_rank(m):
    with open("freq.json", "w") as json_file:
            d1 = {"value": m}
            json_string = json.dumps(d1)
            json_file.write(json_string)


with open('test.json') as json_data:
    data = json.load(json_data)
    for i in range(0, 10):
        print(data['Links'][i])
        start(data['Links'][i])